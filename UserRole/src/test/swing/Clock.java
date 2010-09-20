package test.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
public class Clock extends JPanel implements Runnable {
	Font font48 = new Font("serif", Font.BOLD, 48);
	int i = 1000;
	boolean stop = false;
	Thread thread;

	public Clock() {
		this.setMinimumSize(new Dimension(156, 48));
		this.setPreferredSize(new Dimension(156, 48));
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setFont(font48);

		g2.setBackground(new Color(111, 146, 212));
		g2.clearRect(0, 0, d.width, d.height);
		g2.setColor(Color.yellow);
		g2.drawString("" + i, 16, 40);
	}

	public void start() {
		stop = false;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		Thread currentThread = Thread.currentThread();

		while (!stop && thread == currentThread) {
			i++;
			repaint();
			try {
				thread.sleep(100l);
			} catch (InterruptedException ex) {
			}
		}

	}

	public void stop() {
		stop = true;
		if (thread != null) {
			thread = null;
		}

	}
}
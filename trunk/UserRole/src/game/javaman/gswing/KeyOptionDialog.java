package game.javaman.gswing;

/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import java.awt.*;
import javax.swing.*;
import game.javaman.*;
import javax.swing.border.*;
import java.awt.event.*;

public class KeyOptionDialog extends JDialog {
	GameConfigure gameconfigure = GameConfigure.getInstance();
	LanguageSelect ls = LanguageSelect.getInstance(); // LanguageSelect.getInstance(gameconfigure.getLanguage());
	ButtonGroup buttonGroup = new ButtonGroup();
	JTextField leftL = new JTextField();
	JTextField rightL = new JTextField();
	JTextField pauseL = new JTextField();

	JRadioButton pauseRB;
	JRadioButton leftRB;
	JRadioButton rightRB;

	TitledBorder titledBorder1;
	JButton confirm;
	JButton cancel;
	int selecti = 0;

	KeyListener keylistener;

	public KeyOptionDialog(Frame parent) {
		this.setTitle("Keyboard Setting");
		this.setModal(true);
		this.setResizable(false);
		// this.setSize(230, 284);
		this.setBounds((int) parent.getX() + 20, (int) parent.getY() + 75, 230,
				200);
		ls.setLanguage(gameconfigure.getLanguage());
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		confirm = new JButton(ls.getString(16));
		cancel = new JButton(ls.getString(18));
		pauseRB = new JRadioButton(ls.getString(22));
		leftRB = new JRadioButton(ls.getString(13));
		rightRB = new JRadioButton(ls.getString(14));

		Container container = this.getContentPane();
		titledBorder1 = new TitledBorder(ls.getString(11));
		container.setLayout(null);
		leftL.setEditable(false);
		leftL.setBounds(new Rectangle(116, 24, 84, 20));
		leftL.setText(gameconfigure.getLeftKeyCode() + " "
				+ KeyEvent.getKeyText(gameconfigure.getLeftKeyCode()));
		leftRB.setBounds(new Rectangle(5, 23, 97, 20));
		leftRB
				.addActionListener(new KeyOptionDialog_leftRB_actionAdapter(
						this));

		rightRB.setBounds(new Rectangle(5, 48, 97, 20));
		rightRB.addActionListener(new KeyOptionDialog_rightRB_actionAdapter(
				this));

		rightL.setText(gameconfigure.getRightKeyCode() + " "
				+ KeyEvent.getKeyText(gameconfigure.getRightKeyCode()));
		rightL.setEditable(false);
		rightL.setBounds(new Rectangle(116, 49, 84, 20));

		confirm.setBounds(new Rectangle(110, 114, 85, 20));

		confirm.addActionListener(new KeyOptionDialog_confirm_actionAdapter(
				this));
		cancel.setBounds(new Rectangle(18, 114, 85, 20));
		cancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel_actionPerformed(e);
			}
		});

		pauseRB.setBounds(new Rectangle(6, 74, 97, 20));
		pauseRB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pauseRB_actionPerformed(e);
			}
		});
		pauseL.setText(gameconfigure.getPausekeyCode() + " "
				+ KeyEvent.getKeyText(gameconfigure.getPausekeyCode()));
		pauseL.setBounds(new Rectangle(117, 75, 84, 20));
		pauseL.setEditable(false);
		container.add(leftL, null);
		container.add(rightL, null);
		container.add(rightRB, null);
		container.add(leftRB, null);
		container.add(pauseL, null);
		container.add(confirm, null);
		container.add(cancel, null);
		container.add(pauseRB, null);
		keylistener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				switch (KeyOptionDialog.this.selecti) {
				case 1:

					leftL.setText(e.getKeyCode() + " "
							+ e.getKeyText(e.getKeyCode()));
					gameconfigure.setLeftKeyCode(e.getKeyCode());
					break;
				case 2:
					rightL.setText(e.getKeyCode() + " "
							+ e.getKeyText(e.getKeyCode()));
					gameconfigure.setRightKeyCode(e.getKeyCode());
					break;

				case 6:
					pauseL.setText(e.getKeyCode() + " "
							+ e.getKeyText(e.getKeyCode()));
					gameconfigure.setPausekeyCode(e.getKeyCode());
					break;
				}
			}
		};

		Component[] com = container.getComponents();
		for (int i = 0; i < com.length; i++) {
			com[i].addKeyListener(keylistener);
		}
		buttonGroup.add(leftRB);
		buttonGroup.add(rightRB);
		buttonGroup.add(pauseRB);
	}

	void confirm_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	void leftRB_actionPerformed(ActionEvent e) {
		selecti = 1;
	}

	void rightRB_actionPerformed(ActionEvent e) {
		selecti = 2;
	}

	void pauseRB_actionPerformed(ActionEvent e) {
		selecti = 6;
	}

	void cancel_actionPerformed(ActionEvent e) {
		gameconfigure.defaultKeyOption();
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class KeyOptionDialog_confirm_actionAdapter implements
		java.awt.event.ActionListener {
	KeyOptionDialog adaptee;

	KeyOptionDialog_confirm_actionAdapter(KeyOptionDialog adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.confirm_actionPerformed(e);
	}
}

class KeyOptionDialog_leftRB_actionAdapter implements
		java.awt.event.ActionListener {
	KeyOptionDialog adaptee;

	KeyOptionDialog_leftRB_actionAdapter(KeyOptionDialog adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.leftRB_actionPerformed(e);
	}
}

class KeyOptionDialog_rightRB_actionAdapter implements
		java.awt.event.ActionListener {
	KeyOptionDialog adaptee;

	KeyOptionDialog_rightRB_actionAdapter(KeyOptionDialog adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.rightRB_actionPerformed(e);
	}
}

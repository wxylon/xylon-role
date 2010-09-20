package game.henry.game;
/**
 * @author henry
 * www.riabbs.com
 *
 * @version 1.0
 */
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ImagePanel
    extends JPanel {
    private Point2D.Double position;
    private ImageIcon imageIcon;
    public ImagePanel() {
        init();
    }

    public ImagePanel(ImageIcon imageIcon) {
        init();
        initImage(imageIcon);
    }

    protected void initImage(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
        Image image = imageIcon.getImage();
        setSize(
            image.getWidth(this), image.getHeight(this));
        repaint();
    }

    private void init() {
        this.setLayout(null);
        this.setDoubleBuffered(true);
        setOpaque(false);
        //setOpaque(true);
        position = new Point2D.Double(0, 0);
        setLocation(0, 0);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageIcon != null) {
            imageIcon.paintIcon(this, g, 0, 0);
        }
    }

    public void setImage(ImageIcon imageIcon) {
        initImage(imageIcon);
    }

    public void setPosition(double x, double y) {
        position.setLocation(x, y);
        setLocation( (int) x, (int) y);
    }

    public Point2D.Double getPosition() {
        return position;
    }
}

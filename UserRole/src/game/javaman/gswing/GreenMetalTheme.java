package game.javaman.gswing;

import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import java.awt.*;

/**
 * This class describes a theme using "green" colors.
 * 
 * @version 1.8 01/23/03
 * @author Steve Wilson
 */
public class GreenMetalTheme extends DefaultMetalTheme {
	private Font font = new Font("Dialog", 0, 12);
	private final FontUIResource fontuiresource = new FontUIResource(font);

	public String getName() {
		return "Emerald";
	}

	// greenish colors
	private final ColorUIResource primary1 = new ColorUIResource(51, 102, 51);
	private final ColorUIResource primary2 = new ColorUIResource(102, 153, 102);
	private final ColorUIResource primary3 = new ColorUIResource(153, 204, 153);

	protected ColorUIResource getPrimary1() {
		return primary1;
	}

	protected ColorUIResource getPrimary2() {
		return primary2;
	}

	protected ColorUIResource getPrimary3() {
		return primary3;
	}

	public FontUIResource getControlTextFont() {
		return fontuiresource;
	}

	public FontUIResource getSystemTextFont() {
		return fontuiresource;
	}

	public FontUIResource getUserTextFont() {
		return fontuiresource;
	}

	public FontUIResource getMenuTextFont() {
		return fontuiresource;
	}

	public FontUIResource getWindowTitleFont() {
		return fontuiresource;
	}

	public FontUIResource getSubTextFont() {
		return new FontUIResource(font);
	}

}

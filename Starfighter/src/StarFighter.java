import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class StarFighter extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		try {
			Image icon = ImageIO.read(getClass().getResource("/images/ship.jpg"));
			setIconImage(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getWidthConstant() {
		return WIDTH;
	}

	public static int getHeightConstant() {
		return HEIGHT;
	}
	public static void main( String args[] )
	{
		StarFighter run = new StarFighter();
	}
}
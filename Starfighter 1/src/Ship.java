import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
		this(x, y, 50, 50, 10);
	}

	public Ship(int x, int y, int s)
	{
		this(x, y, 50, 50, s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/ship.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Unable to load image file.");
			e.printStackTrace();
		}
	}


	public void setSpeed(int s)
	{
	speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
		int speed = getSpeed();

		if(direction.equals("LEFT") && getX() - speed >= 0)
		{
			setX(getX() - speed);
		}
		if(direction.equals("RIGHT") && getX() + getWidth() + speed <= StarFighter.getWidthConstant()) // 800 is the width of the projected area
		{
			setX(getX() + speed);
		}
		if(direction.equals("UP") && getY() - speed >= 0)
		{
			setY(getY() - speed);
		}
		if(direction.equals("DOWN") && getY() + getHeight() + speed <= StarFighter.getHeightConstant()) // 600 is the height of the projected area
		{
			setY(getY() + speed);
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}

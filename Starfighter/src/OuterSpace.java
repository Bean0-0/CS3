import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;

	private Ammo ammo;

	//uncomment once you are ready for this part
	private AlienHorde horde;
	private Bullets shots;


	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(400, 450, 50, 50, 5);
		alienOne = new Alien(350, 100, 50, 50, 5);
		alienTwo = new Alien(450, 100, 50, 50, 5);

		this.addKeyListener(this);
		new Thread(this).start();


		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }
	public boolean checkCollision(MovingThing obj1, MovingThing obj2) {
		return (obj1.getX() < obj2.getX() + obj2.getWidth() &&
				obj1.getX() + obj1.getWidth() > obj2.getX() &&
				obj1.getY() < obj2.getY() + obj2.getHeight() &&
				obj1.getY() + obj1.getHeight() > obj2.getY());
	}

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		//add code to move Ship, Alien, etc.

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		if (keys[4] = true) {
			Ammo bullet = new Ammo(ship.getX() + ship.getWidth() / 2, ship.getY(), 5);
			shots.add(bullet);
		}

		// Move the aliens in a fixed direction
		/**
		 * alienOne.move("RIGHT");
		 * 	alienTwo.move("LEFT");
		 */

		// Draw the ship and aliens
		ship.draw(graphToBack);
		alienOne.draw(graphToBack);
		alienTwo.draw(graphToBack);



		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		/*for (int i = 0; i < shots.getList().size(); i++) {
			Ammo bullet = shots.getList().get(i);

			if (checkCollision(bullet, ship)) {
				// handle ship being hit by a bullet
				// for example, end the game or reduce player's lives
			}

			for (Alien alien : horde.getList()) {
				if (checkCollision(bullet, alien)) {
					// handle alien being hit by a bullet
					// for example, remove the alien and the bullet
					horde.getList().remove(alien);
					shots.getList().remove(bullet);
					break;
				}
			}
		}
		*/
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}


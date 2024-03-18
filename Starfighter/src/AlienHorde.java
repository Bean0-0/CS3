import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		for (int i = 0; i < size; i++) {
			aliens.add(new Alien(i * 50, 0, 1));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a : aliens) {
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien a : aliens) {
			a.move("DOWN");
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (Ammo shot : shots) {
			aliens.removeIf(a -> a.getX() == shot.getX() && a.getY() == shot.getY());
		}
	}

	public List<Alien> getList()
	{
		return aliens;
	}
	public String toString()
	{
		return aliens.toString();
	}
}

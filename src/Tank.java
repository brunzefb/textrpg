import java.io.Serializable;
import processing.core.PApplet;
import processing.core.PImage;

public class Tank implements Serializable {
	public int hp; // not so good
	public String name;
	private int ammo; // better
	private int x;
	private int y;

	private PApplet app;

	// Constructor of the class
	// this is where default values are assigned
	public Tank(PApplet p, String givenName) {
		this.app = p;
		name = givenName;
		hp = 65;
		ammo = 10;
		x = 0;
		y = 0;

	}

	public Tank(PApplet p, String givenName, int x, int y) {
		this.app = p;
		name = givenName;
		hp = 65;
		ammo = 10;

		setLocation(x, y);

	}

	public int getHP() {
		return hp;
	}

	public void chHP(int change) {
		if (change >= 50) {
			System.out.println("Too great of a change.");

		} else {
			hp = hp + change;
		}
	}

	public void shoot(Tank target) {
		this.ammo = this.ammo - 1;
		System.out.println(this.name + " has shot " + target.name); // usually
																	// bad
																	// practice
		target.chHP(-10);

	}

	public int getAmmo() {
		return ammo;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;

	}

	public int getY() {
		return y;

	}

	public void drawTank() {
		app.image(app.loadImage("tankBase.png"), getX(), getY());

	}

	public void drawHP() {
		if (getHP() == 65) {
			app.fill(0, 255, 0);
		} else {
			app.fill(255, 0, 0);
		}

		app.rect(getX(), getY() - 10, (float) (getHP() * 0.5), 5);

	}

	public String toString() {
		return ("Name: " + name + "\nHP: " + hp + "\nAmmo: " + ammo + "\n(" + getX() + "," + getY() + ")");
	}

}

package myRPG;

public class Enemy extends Player
{
	private String name;
	private int damage;
	private int xPosOfEnemy;
	private int yPosOfEnemy;
	
	public Enemy (String n, int d , int x, int y , int h)
	{
		super(n, h);
		damage = d;
		name = n;
		xPosOfEnemy = x;
		yPosOfEnemy = y;
	}
	
	public void attack (Hero a, int b)
	{
		int newHeroHp = a.getHp() - damage;
		a.setHp(newHeroHp);
	}
	
	public int getDamage ()
	{
		return damage;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public int getX ()
	{
		return xPosOfEnemy;
	}
	
	public int getY()
	{
		return yPosOfEnemy;
	}
	
}

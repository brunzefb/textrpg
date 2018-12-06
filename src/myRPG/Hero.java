package myRPG;

public class Hero extends Player
{
	private String n;
	
	//Constructor of the class (default values are assigned here)
	//@param name the name of the player
	public Hero (String name)
	{
	   super (name);
	}
	//Attacks an enemy
	//@param a the enemy you are targeting
	//@param damage the amount of damage being dealt
	public void attack(Enemy a, int damage)
	{
		int newEnemyHp = a.getHp() - damage;
		a.setHp(newEnemyHp);
	}
}

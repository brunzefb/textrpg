package myRPG;

public class Weapon extends Item
{
    private int weaponDamage;

    //Constructor of the class (initial values are given here)
    //@param n name
    //@param w weight
    //@param x the x position of the weapon
    //@param y the y position of the weapon
    public Weapon(String n, double w, int x, int y, int d)
    {
        super(n, w, x, y);
        weaponDamage = d;
    }

    //Gets the damage of a weapon
    //@return weaponDamage returns the damage of the weapon.
    public int getDamage()
    {
        return weaponDamage;
    }
}

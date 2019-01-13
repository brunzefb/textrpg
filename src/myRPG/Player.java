package myRPG;

import java.io.Serializable;
import processing.*;
import processing.core.PApplet;

public class Player extends PApplet 
{
    private String name;
    private int hp;
    static int maxHp;

    //Constructor of the class (default values are assigned here)
    //@param n the name of the player
    public Player(String n)
    {
        name = n;
        hp = 100;
        maxHp = 100;
    }
    //Overloaded constructor
    //@param n name of the player
    //@param h the hp of the player
    public Player(String n, int h)
    {
        name = n;
        hp = h;
    }

    //gets the name of the player
    //@return name the name of the player
    public String getName()
    {
        return name;
    }

    //sets the hp of the player
    //@param a the amount of hp
    public void setHp(int a)
    {
        hp = a;
    }

    //gets the hp of the player
    //@return hp the players hp
    public int getHp()
    {
        return hp;
    }
}

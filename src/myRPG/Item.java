package myRPG;
import processing.*;
import processing.core.PApplet;

import java.io.Serializable;

public class Item extends PApplet //implements Serializable
{
    private String name;
    private double weight;
    private int xPosOfItem;
    private int yPosOfItem;

    
    //Constructor of the class (default values assigned)
    //@param n name of the item
    //@param w the weight of the item
    //@param x the x coordinate of the item
    //@param y the y coordinate of the item
    public Item(String n, double w, int x, int y)
    {
        name = n;
        weight = w;
        xPosOfItem = x;
        yPosOfItem = y;
    }
    //prints out the name of an item
    public void printItem()
    {
        System.out.println(name);
    }
    //gets the weight of an item
    //@return weight the weight of the item
    public double getWeight()
    {
        return weight;
    }
    //gets the x coordinate of the item
    //@return xPosOfItem the x position of the item
    public int getX()
    {
        return xPosOfItem;
    }
    //gets the y coordinate of the item
    //@return yPosOfItem the y position of the item
    public int getY()
    {
        return yPosOfItem;
    }
    //gets the name of the player
    //@return the name of the player
    public String getName()
    {
        return name;
    }
    //sets the x position of an item
    //@param a the new x pos of the item
    public void setX(int a)
    {
        xPosOfItem = a;
    }
    //sets the y positions of an item
    //@param a the new y pos of the item
    public void setY(int a)
    {
        yPosOfItem = a;
    }
}

package myRPG;

import java.io.Serializable;

public class Item implements Serializable
{
	private String name;
	private double weight;
	private int xPosOfItem;
	private int yPosOfItem;
	
	public Item (String n, double w,  int x, int y) 
	{
		name = n;
		weight = w;	
		xPosOfItem = x;
		yPosOfItem = y;
	}
	
	public void printItem ()
	{
		System.out.println(name);
	}
	
	public double getWeight ()
	{
		return weight;
	}
	
	public int getX ()
	{
		return xPosOfItem;
	}
	
	public int getY ()
	{
		return yPosOfItem;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public void setX(int a)
	{
		xPosOfItem = a;
	}
	
	public void setY (int a)
	{
		yPosOfItem = a;
	}
}

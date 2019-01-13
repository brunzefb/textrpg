package myRPG;
import processing.*;
import processing.core.PApplet;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory extends PApplet //implements Serializable
{
    ArrayList<Item> bag = new ArrayList<Item>();
    private int capacity;
    private int sum;

    //Constructor of the class (default values are assigned here)
    //@param c the capacity of the bag
    public Inventory(int c)
    {
        capacity = c;
    }

    //adds an item to your bag
    //@param a the item to be added
    public void addItemToBag(Item a)
    {
        int spaceLeftInBag = capacity - getCurrentWeight();
        if (a.getWeight() < spaceLeftInBag)
        {
            bag.add(a);
        }
        else
        {
            System.out.println("You have too many items in your bag!");
        }
    }

    //checks to see if you have an item or not
    //@return true if name = input
    public boolean hasItem(String a)
    {
        for (int i = 0; i < bag.size(); i++)
        {
            if (bag.get(i).getName().equals(a))
            {
                return true;
            }
        }
        return false;
    }

    //returns the damage of a weapon
    //@param the name of the weapon
    //@return ((Weapon)bag.get(i)).getDamage() the damage of weapon
    public int damageForWeapon(String weaponName)
    {
        weaponName = weaponName.replace("\n", "").replace("\r", "");
        for (int i = 0; i < bag.size(); i++)
        {
            String itemName = bag.get(i).getName();
            if (itemName.equalsIgnoreCase(weaponName) == true)
            {
                return ((Weapon) bag.get(i)).getDamage();
            }
        }
        return 0;
    }

    //prints all the weapons in the players inventory
    public void printWeapons()
    {
        for (int i = 0; i < bag.size(); i++)
        {
            if (bag.get(i) instanceof Weapon)
            {
                Weapon w = (Weapon) bag.get(i);
                System.out.println(w.getName() + " with " + w.getDamage() + " damage");
            }
        }
    }

    //removes an item from your bag
    //@param a the item you would like to remove
    public void removeItemFromBag(String a)
    {
        for (int i = 0; i < bag.size(); i++)
        {
            if (bag.get(i).getName().equalsIgnoreCase(a) == true)
            {
                String name = bag.get(i).getName();
                bag.remove(i);
                System.out.println(name + " has been removed.");
                return;
            }
        }
        System.out.println("The item is not in your bag!");
    }

    //gets the current weight of the players bag
    //@return sum the sum of the items in the bag
    public int getCurrentWeight()
    {
        sum = 0;
        for (int i = 0; i < bag.size(); i++)
        {
            sum += bag.get(i).getWeight();
        }
        return sum;
    }

    //gets the capacity of the players bag
    //@return capacity the capacity of the bag.
    public int getCapacity()
    {
        return capacity;
    }

    //prints the players inventory
    public void printInventory()
    {
        for (int i = 0; i < bag.size(); i++)
        {
            System.out.println(bag.get(i).getName());
        }
    }
}

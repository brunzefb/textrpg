package myRPG;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RunGame 
{
	public static void main (String [] args)  throws IOException
	{
		Scanner sc = new Scanner (System.in);
		//FileOutputStream fout = new FileOutputStream("save.ser");
		//ObjectOutputStream oos = new ObjectOutputStream(fout);
		boolean keyToCastleFound = false;
		boolean henchmanKilled = false;
		boolean mrQinKilled = false;
		boolean feralCrystalKilled = false;
		boolean extremelyGayChrisKilled = false;
		boolean healthPotionOnePickedUp = false;
		boolean healthPotionTwoPickedUp = false;
		boolean healthPotionThreePickedUp = false;
		boolean healthPotionFourPickedUp = false;
		boolean healthPotionFivePickedUp = false;
		boolean daggerPickedUp = false;
		boolean swordPickedUp = false;
		boolean longswordPickedUp = false;
		MapOfGame map = new MapOfGame();
        printStory();
        String heroName = sc.nextLine();
        Hero user = new Hero (heroName);
        printInstructions();
        Inventory inventory = new Inventory (200);
        Encounter spawnItem = new Encounter ();
        Item keyToCastle = new Item ("Key", 5.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        if (keyToCastle.getX() == 4 && keyToCastle.getY() == 8)
        {
        	keyToCastle.setY(3);
        }
        //add health potions to array list
        Item healthPotion = new Item ("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionTwo = new Item ("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionThree = new Item ("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionFour = new Item ("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionFive = new Item ("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Weapon Dagger = new Weapon ("Dagger" , 25.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 15);
        Weapon Sword = new Weapon ("Sword", 45.0 , spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 24);
        Weapon Longsword = new Weapon ("Long Sword" , 65.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 29);
        Enemy feralCrystal = new Enemy ("Feral Crystal", 13, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(),100);
        Enemy Henchman = new Enemy ("Henchman," , 8 , spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        Enemy mrQin = new Enemy ("Mr Qin", 10, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        Enemy extremelyGayChris = new Enemy ("Really Happy Chris", 15, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        map.initializeArray();
        while (user.getHp() > 0)
        {
          	map.printMap();
        	map.getCurrentLocation();
        	System.out.println("Which direction would you like to go?");
        	if (map.getX()+1 == healthPotion.getX() && map.getY()+1 == healthPotion.getY() && healthPotionOnePickedUp == false)
        	{
        		System.out.println("You found a health potion!");
        		inventory.addItemToBag(healthPotion);
        		healthPotionOnePickedUp = true;
        	}
        	if (map.getX()+1 == healthPotionTwo.getX() && map.getY()+1 == healthPotionTwo.getY() && healthPotionTwoPickedUp == false)
        	{
        		System.out.println("You found a health potion!");
        		inventory.addItemToBag(healthPotionTwo);
        		healthPotionTwoPickedUp = true;
        	}
        	if (map.getX()+1 == healthPotionThree.getX() && map.getY()+1 == healthPotionThree.getY() && healthPotionThreePickedUp == false)
        	{
        		System.out.println("You found a health potion!");
        		inventory.addItemToBag(healthPotionThree);
        		healthPotionOnePickedUp = true;
        	}
        	if (map.getX()+1 == healthPotionFour.getX() && map.getY()+1 == healthPotionFour.getY() && healthPotionFourPickedUp == false)
        	{
        		System.out.println("You found a health potion!");
        		inventory.addItemToBag(healthPotionFour);
        		healthPotionFourPickedUp = true;
        	}
        	
        	if (map.getX()+1 == healthPotionFive.getX() && map.getY()+1 == healthPotionFive.getY() && healthPotionFivePickedUp == false)
        	{
        		System.out.println("You found a health potion!");
        		inventory.addItemToBag(healthPotionFive);
        		healthPotionFivePickedUp = true;
        	}
        	
        	if (map.getX()+1 == Dagger.getX() && map.getY()+1 == Dagger.getY() && daggerPickedUp == false)
        	{
        		System.out.println("You found a dagger!");
        		inventory.addItemToBag(Dagger);
        		daggerPickedUp = true;
        	}
        	if (map.getX()+1 == Sword.getX() && map.getY()+1 == Sword.getY() && swordPickedUp == false)
        	{
        		System.out.println("You found a Sword!");
        		inventory.addItemToBag(Sword);
        		swordPickedUp = true;
        	}
        	if (map.getX()+1 == Longsword.getX() && map.getY()+1 == Longsword.getY() && longswordPickedUp == false)
        	{
        		System.out.println("You found a Long Sword!");
        		inventory.addItemToBag(Longsword);
        		longswordPickedUp = true;
        	}
        	
        	if (map.getX()+1 == keyToCastle.getX() && map.getY()+1 == keyToCastle.getY() && keyToCastleFound == false)
        	{
        		System.out.println("You found the key to Lu's Castle!");
        		System.out.println("Now you can open the door to his castle and try to overthrow him as leader.");
        		inventory.addItemToBag(keyToCastle);
        		keyToCastleFound = true;
        	}
        	
        	if (map.getX()+1 == Henchman.getX() && map.getY() == Henchman.getY() && henchmanKilled == false)
        	{
        		System.out.println("");
        		System.out.println("You encountered an enemy!");
        		System.out.println("The henchman flips you off!");
        		System.out.println("");
        		System.out.println("Which weapon would you like to use");
        		System.out.println("----------------------------------");
        		System.out.println("You have these weapons at your disposal");
        		inventory.printWeapons();
        		String choice = sc.nextLine();
        		int damage = inventory.damageForWeapon(choice);
        		if (damage == 0)
        		{
        			System.out.println("You don't have that weapon!");
        			System.out.println("Your default damage is 10");
        			System.out.println("");
        			damage = 10;
        		}
        	
    			while (Henchman.getHp() >= 0 && user.getHp() >= 0)
    			{
    				user.attack(Henchman, damage);
 				    try
        		    {
					   TimeUnit.SECONDS.sleep(1);
				    } 
        		    catch (InterruptedException e) 
        		    {
					  e.printStackTrace();
				    }
    				System.out.println("You attacked the henchman, his new health is " + Henchman.getHp());
    				if (Henchman.getHp() <= 0)
    					break;
    				Henchman.attack(user, damage);
 				    try
        		    {
					   TimeUnit.SECONDS.sleep(1);
				    } 
        		    catch (InterruptedException e) 
        	 	    {
					  e.printStackTrace();
				    }
    				System.out.println("You were hit by the henchman, your new health is " + user.getHp());
    				if (user.getHp() <= 0)
    					break;
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " + user.getHp()+" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    		     }
    			
    			if (user.getHp() > Henchman.getHp())
    			{
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " +user.getHp()+" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    				System.out.println("");
    			    System.out.println("Congratulations! You killed the henchman");
    			    System.out.println("Type any key to return");
    			    henchmanKilled = true;
    			}
    			
    			else
    			{
    				System.out.println("");
    				System.out.println("You got killed by a henchman? Wow you suck.");
    				System.out.println("Gameover!");
    			}
        	}
        	
        	if (map.getX()+1 == feralCrystal.getX() && map.getY() == feralCrystal.getY() && feralCrystalKilled == false)
        	{
        		System.out.println("");
        		System.out.println("You encountered an enemy!");
        		System.out.println("A feral Crystal awkwardly stares at you!");
        		System.out.println("She attacks!");
        		System.out.println("");
        		System.out.println("Which weapon would you like to use");
        		System.out.println("----------------------------------");
        		System.out.println("You have these weapons at your disposal");
        		inventory.printWeapons();
        		String choice = sc.nextLine();
        		int damage = inventory.damageForWeapon(choice);
        		if (damage == 0)
        		{
        			System.out.println("You don't have that weapon!");
        			System.out.println("Your default damage is 10");
        			System.out.println("");
        			damage = 10;
        		}
        	
    			while (feralCrystal.getHp() >= 0 && user.getHp() >= 0)
    			{
    				user.attack(feralCrystal, damage);
 				    try
        		    {
					   TimeUnit.SECONDS.sleep(1);
				    } 
        		    catch (InterruptedException e) 
        		    {
					  e.printStackTrace();
				    }
    				System.out.println("You attacked the feral Crystal, her new health is " + feralCrystal.getHp());
    				if (feralCrystal.getHp() <=0)
    					break;
    				feralCrystal.attack(user, damage);
 				    try
        		    {
					   TimeUnit.SECONDS.sleep(1);
				    } 
        		    catch (InterruptedException e) 
        		    {
					  e.printStackTrace();
				    }
    				System.out.println("You were hit by the feral Crystal, your new health is " + user.getHp());
    				if (user.getHp()<=0)
    					break;
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " + user.getHp() +" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    		     }
    			
    			if (user.getHp() > feralCrystal.getHp())
    			{
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " +user.getHp() +" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    				System.out.println("");
    			    System.out.println("Congratulations! You killed the feral Crystal!");
    			    System.out.println("Type any key to return");
    			    feralCrystalKilled = true;
    			}
    			
    			else
    			{
    				System.out.println("");
    				System.out.println("You got killed by the feral Crystal?");
    				System.out.println("Man... she's probably gonna eat your body that sucks.");
    				System.out.println("Gameover!");
    			}
        	}
        	
        	if (map.getX()+1 == extremelyGayChris.getX() && map.getY() == extremelyGayChris.getY() && extremelyGayChrisKilled == false)
        	{
        		System.out.println("");
        		System.out.println("You encountered an enemy!");
        		System.out.println("The extremely gay chris says something really profane!");
        		System.out.println("When you dont respond, he attacks!");
        		System.out.println("");
        		System.out.println("Which weapon would you like to use");
        		System.out.println("----------------------------------");
        		System.out.println("You have these weapons at your disposal");
        		inventory.printWeapons();
        		String choice = sc.nextLine();
        		int damage = inventory.damageForWeapon(choice);
        		if (damage == 0)
        		{
        			System.out.println("You don't have that weapon!");
        			System.out.println("Your default damage is 10");
        			System.out.println("");
        			damage = 10;
        		}
        	
    			while (extremelyGayChris.getHp() >= 0 && user.getHp() >= 0)
    			{
    				user.attack(extremelyGayChris, damage);
 				    try
        		    {
					   TimeUnit.SECONDS.sleep(1);
				    } 
        		    catch (InterruptedException e) 
        		    {
					  e.printStackTrace();
				    }
    				System.out.println("You attacked the Really Gay Chris, his new health is " + extremelyGayChris.getHp());
    				if (extremelyGayChris.getHp() <= 0)
    					break;
    				extremelyGayChris.attack(user, damage);
 				    try
        		    {
					   TimeUnit.SECONDS.sleep(1);
				    } 
        		    catch (InterruptedException e) 
        		    {
					  e.printStackTrace();
				    }
    				System.out.println("You were hit by the Really Gay Chris, your new health is " + user.getHp());
    				if (user.getHp() <= 0)
    					break;
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " + user.getHp()+" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    		     }
    			
    			if (user.getHp() > extremelyGayChris.getHp())
    			{
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " +user.getHp()+" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    				System.out.println("");
    			    System.out.println("Congratulations! You killed the Really Gay Chris");
    			    System.out.println("Type any key to return");
    			    extremelyGayChrisKilled = true;
    			}
    			
    			else
    			{
    				System.out.println("");
    				System.out.println("You got killed by Really Gay Chris");
    				System.out.println("He says that your body looks scrumptious");
    				System.out.println("Gameover!");
    			}
        	}
        	
        	if (map.getX()+1 == mrQin.getX() && map.getY() == mrQin.getY() && mrQinKilled == false)
        	{
        		System.out.println("");
        		System.out.println("You encountered an enemy!");
        		System.out.println("Mr Qin emerges from the bushes!");
        		System.out.println("");
        		System.out.println("Which weapon would you like to use");
        		System.out.println("----------------------------------");
        		System.out.println("You have these weapons at your disposal");
        		inventory.printWeapons();
        		String choice = sc.nextLine();
        		int damage = inventory.damageForWeapon(choice);
        		if (damage == 0)
        		{
        			System.out.println("You don't have that weapon!");
        			System.out.println("Your default damage is 10");
        			System.out.println("");
        			damage = 10;
        		}
        	
    			while (mrQin.getHp() >= 0 && user.getHp() >= 0)
    			{
    				user.attack(mrQin, damage);
    				System.out.println("You attacked the Mr Qin, his new health is " + mrQin.getHp());
    				   try
            		   {
    					   TimeUnit.SECONDS.sleep(1);
    				   } 
            		   catch (InterruptedException e) 
            		   {
    					  e.printStackTrace();
    				   }
    				if (mrQin.getHp() <=0)
    					break;
    				mrQin.attack(user, damage);
    				System.out.println("You were hit by the Mr Qin, your new health is " + user.getHp());
    				   try
            		   {
    					   TimeUnit.SECONDS.sleep(1);
    				   } 
            		   catch (InterruptedException e) 
            		   {
    					  e.printStackTrace();
    				   }
    				if (user.getHp()<=0)
    					break;
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " + user.getHp() +" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    		     }
    			
    			if (user.getHp() > mrQin.getHp())
    			{
    				if (user.getHp() < 30 && inventory.hasItem("Health Potion")==true)
    				{
    					user.setHp(100);
    					System.out.println("You used a health potion, your health has been restored to " +user.getHp() +" hp.");
    					inventory.removeItemFromBag("Health Potion");
    				}
    				System.out.println("");
    			    System.out.println("Congratulations! You killed Mr Qin!");
    			    System.out.println("Type any key to return");
    			    mrQinKilled = true;
    			}
    			
    			else
    			{
    				System.out.println("");
    				System.out.println("You got killed by Mr Qin?");
    				System.out.println("That's pretty understandable. but still...");
    				System.out.println("Gameover!");
    			}
        	}

        	
        	String input = sc.nextLine();
        	if (input.equalsIgnoreCase("i") == true || input.equalsIgnoreCase("inventory") == true)	
        	{
        		System.out.println ("Welcome To Your Inventory | Your Current HP is " + user.getHp()+" hp");
        		System.out.println("-----------------------------------------------------");
        		inventory.printInventory();
        		System.out.println("");
        		System.out.println("Your bags weight is " + inventory.getCurrentWeight() + "/" + inventory.getCapacity());
        		System.out.println("");
        		System.out.println("If you would like to remove an item from your bag, type 'd'");
        		System.out.println("If you would like to close your inventory, hit any other key.");
        		System.out.println("If you would like to save your game type 's'");
        		String selection = sc.nextLine();
        		if (selection.equalsIgnoreCase("d")==true)
        		{
        			System.out.println("Please enter the name of the item you would like to drop");
        			inventory.removeItemFromBag(sc.nextLine());
        		}	
        		
        		else if (selection.equalsIgnoreCase("s")==true)
        		{
        			System.out.println("We're gonna save your game now.");
        			FileOutputStream fout = new FileOutputStream("save.ser");
        			ObjectOutputStream oos = new ObjectOutputStream(fout);
        			oos.writeObject(user);
        			oos.writeObject(map);
        			oos.writeObject(healthPotion);
        			oos.writeObject(healthPotionTwo);
        			oos.writeObject(healthPotionThree);
        			oos.writeObject(healthPotionFour);
        			oos.writeObject(healthPotionFive);
        			oos.writeObject(Dagger);
        			oos.writeObject(Sword);
        			oos.writeObject(Longsword);
        			oos.writeObject(feralCrystal);
        			oos.writeObject(Henchman);
        			oos.writeObject(extremelyGayChris);
        			oos.writeObject(mrQin);
        			oos.close();
        		}
        	}
        	
        	else
        	{
        		if (map.getX() == 4 && map.getY() == 7 &&input.equalsIgnoreCase("s") == true && keyToCastleFound == false)
        		{
        		   System.out.println("You can't go there without the key!");
        		   System.out.println("");
        		   try
        		   {
					   TimeUnit.SECONDS.sleep(1);
				   } 
        		   catch (InterruptedException e) 
        		   {
					  e.printStackTrace();
				   }
        		}
        		else if (map.getX() == 4 && map.getY() == 7 &&input.equalsIgnoreCase("s") == true && keyToCastleFound == true)
        		{
        			map.movePlayer(input);
        			System.out.println("YOU ENTERED MY CASTLE?!");
        			System.out.println("");
        		}
        		
        		else if (map.getX()==3 && map.getY() == 8 &&input.equalsIgnoreCase("e") == true &&keyToCastleFound == false)
        		{
        			   System.out.println("You can't go there without the key!");
            		   System.out.println("");
            		   try
            		   {
    					   TimeUnit.SECONDS.sleep(1);
    				   } 
            		   catch (InterruptedException e) 
            		   {
    					  e.printStackTrace();
    				   }
        		}
        		
        		else if (map.getX() == 3 && map.getY() == 8 &&input.equalsIgnoreCase("e") == true && keyToCastleFound == true)
        		{
        			map.movePlayer(input);
        			System.out.println("YOU ENTERED MY CASTLE?!");
        			System.out.println("");
        		}
        		
        		else if (map.getX() == 5 && map.getY() == 8 && input.equalsIgnoreCase("w") == true && keyToCastleFound == false)
        		{
        			   System.out.println("You can't go there without the key!");
            		   System.out.println("");
            		   try
            		   {
    					   TimeUnit.SECONDS.sleep(1);
    				   } 
            		   catch (InterruptedException e) 
            		   {
    					  e.printStackTrace();
    				   }
        		}
        		
        		else if (map.getX() == 5 && map.getY() == 8 && input.equalsIgnoreCase("w") == true && keyToCastleFound == true)
        		{
        			map.movePlayer(input);
        			System.out.println("YOU ENTERED MY CASTLE?!");
        			System.out.println("");
        		}
        		
        		else 
        			map.movePlayer(input);
        	}
        }
	}
	
	public static void printStory ()
	{
		Scanner temp = new Scanner (System.in);
		System.out.println("Do you have a saved game? (yes) / (no)");
		String response = temp.nextLine();
		if (response.equalsIgnoreCase("yes")==true)
		{
			
		}
		else
		System.out.println("");
		System.out.println("In a world known as Earth 2 Humanity is ruled over by one man.");
		System.out.println("This man Vincent Lu has ruled over humanity with his henchmen for centuries.");
		System.out.println("The people of Earth 2 have been far too afraid to challenge Lu due to his immense power.");
		System.out.println("At least they had been, until now");
		System.out.println("What is your name Hero?");
	}
	
	public static void printInstructions ()
	{
		Scanner temp = new Scanner (System.in);
		System.out.println("Your objective is to enter Lu's castle and overthrow him as corrupt leader");
		System.out.println("To do so, you must find the key that is located somewhere on the map");
		System.out.println("This key will allow you to enter his castle and fight him for power over the kingdom");
		System.out.println("But be warned the fight against Lu will not be easy, you will need to be prepared");
		System.out.println("Here are some tips:");
		System.out.println("");
		System.out.println("Use, 'N', 'E' ,'S', 'W' to travel around the map (N, for north etc)");
		System.out.println("Hit I to open your inventory to see your various items");
		System.out.println("When in combat select your weapon with the highest damage to have the best odds of winning");
		System.out.println("That's all for now! best of luck to you in freeing the people of Earth 2!");
		System.out.println("");
		System.out.println("Wait wait one more thing, are you feeling confident about beating Lu? (Yes/No)");
		String answer = temp.nextLine();
		if (answer.equalsIgnoreCase("yes")==true)
		{
			System.out.println("Hmmm okay we'll see.");
			System.out.println("");
		}
		else if (answer.equalsIgnoreCase("no")==true)
		{
			System.out.println("Don't worry! you'll be fine! Probably...");
			System.out.println("");
		}	
	}

	
	public static ArrayList loadItems ()
	{
		ArrayList <Item> itemsToBeLoaded = new ArrayList<Item>();
		//itemsToBeLoaded.add(healthPotion);
		return itemsToBeLoaded;
	}
}


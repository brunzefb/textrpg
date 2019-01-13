package myRPG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import processing.*;
import processing.core.PApplet;
import processing.core.PFont;

public class Graphics extends PApplet
{
	  int gameScreen = 0;
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
      ArrayList<Item> healthPotions = new ArrayList<Item>();
      MapOfGame map = new MapOfGame();
      Hero user = new Hero("user");
      Inventory inventory = new Inventory(200);
      Encounter spawnItem = new Encounter();
      Item keyToCastle = new Item("Key", 5.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
      Item healthPotion = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
      Item healthPotionTwo = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
      Item healthPotionThree = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
      Item healthPotionFour = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
      Item healthPotionFive = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
      Weapon Dagger = new Weapon("Dagger", 25.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 15);
      Weapon Sword = new Weapon("Sword", 45.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 24);
      Weapon Longsword = new Weapon("Long Sword", 65.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 29);
      Enemy feralCrystal = new Enemy("Feral Crystal", 13, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
      Enemy Henchman = new Enemy("Henchman,", 8, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
      Enemy mrQin = new Enemy("Mr Qin", 10, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
      Enemy extremelyGayChris = new Enemy("Really Happy Chris", 15, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
      Enemy mrLu = new Enemy("Mr Lu", 25, 5, 8, 200);
      
	public void setup ()
	{
		healthPotions.add(healthPotion);
	    healthPotions.add(healthPotionTwo);
	    healthPotions.add(healthPotionThree);
	    healthPotions.add(healthPotionFour);
	    healthPotions.add(healthPotionFive);
	}
	
	public void settings ()
	{
		size(1024,768);
	}
	
	public void keyPressed()
	{
		
	}
	
	public void draw ()
	{
		if (gameScreen == 0)
		{
			drawMenu();
		}
	}
	
	public static void main(String[] args) 
	{
		  PApplet.main("myRPG.Graphics");
	}
	
	public void drawMenu()
	{
		background (0,134,255);
		textSize(40);
		PFont customFont = createFont("Comic Sans", 32);
		textFont(customFont);
		fill(255,255,255);
		text ("CASTLUMANIA", 385, 150);
		fill(255,255,255);
		strokeWeight(4);
		stroke (0,0,0);
		rect(385, 220, 230, 80);
		fill(50,0,0);
		textSize(25);
		text("PLAY!", 463,270);
		fill(255,0,0);
	}
}
	        
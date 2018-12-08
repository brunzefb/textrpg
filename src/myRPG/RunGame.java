package myRPG;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RunGame
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner sc = new Scanner(System.in);
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
        ArrayList<Item> healthPotions = new ArrayList<Item>();
        boolean daggerPickedUp = false;
        boolean swordPickedUp = false;
        boolean longswordPickedUp = false;
        MapOfGame map = new MapOfGame();
        map.initializeArray();
        System.out.println("What is your name hero?");
        String heroName = sc.nextLine();
        Hero user = new Hero(heroName);
        Inventory inventory = new Inventory(200);
        Encounter spawnItem = new Encounter();
        Item keyToCastle = new Item("Key", 5.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        if (keyToCastle.getX() == 4 && keyToCastle.getY() == 8)
        {
            keyToCastle.setY(3);
        }
        Item healthPotion = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionTwo = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionThree = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionFour = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        Item healthPotionFive = new Item("Health Potion", 10.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation());
        healthPotions.add(healthPotion);
        healthPotions.add(healthPotionTwo);
        healthPotions.add(healthPotionThree);
        healthPotions.add(healthPotionFour);
        healthPotions.add(healthPotionFive);
        Weapon Dagger = new Weapon("Dagger", 25.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 15);
        Weapon Sword = new Weapon("Sword", 45.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 24);
        Weapon Longsword = new Weapon("Long Sword", 65.0, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 29);
        Enemy feralCrystal = new Enemy("Feral Crystal", 13, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        Enemy Henchman = new Enemy("Henchman,", 8, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        Enemy mrQin = new Enemy("Mr Qin", 10, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        Enemy extremelyGayChris = new Enemy("Really Happy Chris", 15, spawnItem.getRandomLocation(), spawnItem.getRandomLocation(), 100);
        Enemy mrLu = new Enemy("Mr Lu", 25, 5, 8, 200);
        Scanner temp = new Scanner(System.in);
        System.out.println("Do you have a saved game? (yes) / (no)");
        String response = temp.nextLine();
        // loads the objects from serialized file
        if (response.equalsIgnoreCase("yes") == true)
        {
            FileInputStream fin = new FileInputStream("save.ser");
            ObjectInputStream ios = new ObjectInputStream(fin);
            inventory = (Inventory) ios.readObject();
            user = (Hero) ios.readObject();
            map = (MapOfGame) ios.readObject();
            healthPotions = (ArrayList<Item>) ios.readObject();
            Dagger = (Weapon) ios.readObject();
            Sword = (Weapon) ios.readObject();
            Longsword = (Weapon) ios.readObject();
            feralCrystal = (Enemy) ios.readObject();
            Henchman = (Enemy) ios.readObject();
            extremelyGayChris = (Enemy) ios.readObject();
            mrQin = (Enemy) ios.readObject();
            fin.close();
        }
        else if (response.equalsIgnoreCase("no") == true)
        {
            printStory();
            printInstructions();
        }
        
        while (user.getHp() > 0)
        {
            map.printMap();
            map.getCurrentLocation();
            System.out.println("Which direction would you like to go?");
            
            if (map.getX() + 1 == healthPotion.getX() && map.getY() + 1 == healthPotion.getY() && healthPotionOnePickedUp == false)
            {
                System.out.println("*You found a health potion!*");
                inventory.addItemToBag(healthPotion);
                healthPotionOnePickedUp = true;
            }
            if (map.getX() + 1 == healthPotionTwo.getX() && map.getY() + 1 == healthPotionTwo.getY() && healthPotionTwoPickedUp == false)
            {
                System.out.println("*You found a health potion!*");
                inventory.addItemToBag(healthPotionTwo);
                healthPotionTwoPickedUp = true;
            }
            if (map.getX() + 1 == healthPotionThree.getX() && map.getY() + 1 == healthPotionThree.getY() && healthPotionThreePickedUp == false)
            {
                System.out.println("*You found a health potion!*");
                inventory.addItemToBag(healthPotionThree);
                healthPotionOnePickedUp = true;
            }
            if (map.getX() + 1 == healthPotionFour.getX() && map.getY() + 1 == healthPotionFour.getY() && healthPotionFourPickedUp == false)
            {
                System.out.println("*You found a health potion!*");
                inventory.addItemToBag(healthPotionFour);
                healthPotionFourPickedUp = true;
            }

            if (map.getX() + 1 == healthPotionFive.getX() && map.getY() + 1 == healthPotionFive.getY() && healthPotionFivePickedUp == false)
            {
                System.out.println("*You found a health potion!*");
                inventory.addItemToBag(healthPotionFive);
                healthPotionFivePickedUp = true;
            }

            if (map.getX() + 1 == Dagger.getX() && map.getY() + 1 == Dagger.getY() && daggerPickedUp == false)
            {
                System.out.println("*You found a dagger!*");
                inventory.addItemToBag(Dagger);
                daggerPickedUp = true;
            }

            if (map.getX() + 1 == Sword.getX() && map.getY() + 1 == Sword.getY() && swordPickedUp == false)
            {
                System.out.println("*You found a Sword!*");
                inventory.addItemToBag(Sword);
                swordPickedUp = true;
            }

            if (map.getX() + 1 == Longsword.getX() && map.getY() + 1 == Longsword.getY() && longswordPickedUp == false)
            {
                System.out.println("*You found a Long Sword!*");
                inventory.addItemToBag(Longsword);
                longswordPickedUp = true;
            }

            if (map.getX() + 1 == keyToCastle.getX() && map.getY() + 1 == keyToCastle.getY() && keyToCastleFound == false)
            {
                System.out.println("*You found the key to Lu's Castle!*");
                System.out.println("Now you can open the door to his castle and try to overthrow him as leader.");
                inventory.addItemToBag(keyToCastle);
                keyToCastleFound = true;
            }

            if (map.getX() + 1 == Henchman.getX() && map.getY() == Henchman.getY() && henchmanKilled == false)
            {
                henchmanKilled = henchmenFight(sc, henchmanKilled, user, inventory, Henchman);
            }

            if (map.getX() + 1 == feralCrystal.getX() && map.getY() == feralCrystal.getY() && feralCrystalKilled == false)
            {
                feralCrystalKilled = feralCrystalFight(sc, feralCrystalKilled, user, inventory, feralCrystal);
            }

            if (map.getX() + 1 == extremelyGayChris.getX() && map.getY() == extremelyGayChris.getY() && extremelyGayChrisKilled == false)
            {
                extremelyGayChrisKilled = extremelyGayChristFight(sc, extremelyGayChrisKilled, user, inventory, extremelyGayChris);
            }

            if (map.getX() + 1 == mrQin.getX() && map.getY() == mrQin.getY() && mrQinKilled == false)
            {
                mrQinKilled = mrQinFight(sc, mrQinKilled, user, inventory, mrQin);
            }


            String input = sc.nextLine();
            if (input.equalsIgnoreCase("i") == true || input.equalsIgnoreCase("inventory") == true)
            {
                promptUser(user, inventory);
                String selection = sc.nextLine();
                if (selection.equalsIgnoreCase("d") == true)
                {
                    System.out.println("Please enter the name of the item you would like to drop");
                    inventory.removeItemFromBag(sc.nextLine());
                }
                else if (selection.equalsIgnoreCase("s") == true)
                {
                    saveGame(healthPotions, map, user, inventory, Dagger, Sword, Longsword, feralCrystal, Henchman, mrQin, extremelyGayChris);
                }
            }
            else
            {
                if (map.getX() == 4 && map.getY() == 7 && input.equalsIgnoreCase("s") == true && keyToCastleFound == false)
                {
                   castleAcessDenied();
                }
                else if (map.getX() == 4 && map.getY() == 7 && input.equalsIgnoreCase("s") == true && keyToCastleFound == true)
                {
                    BossBattle(sc, map, user, inventory, mrLu, input);
                }
                else if (map.getX() == 3 && map.getY() == 8 && input.equalsIgnoreCase("e") == true && keyToCastleFound == false)
                {
                   castleAcessDenied();
                }
                else if (map.getX() == 3 && map.getY() == 8 && input.equalsIgnoreCase("e") == true && keyToCastleFound == true)
                {
                    BossBattle(sc, map, user, inventory, mrLu, input);
                }
                else if (map.getX() == 5 && map.getY() == 8 && input.equalsIgnoreCase("w") == true && keyToCastleFound == false)
                {
                	 castleAcessDenied();
                }
                else if (map.getX() == 5 && map.getY() == 8 && input.equalsIgnoreCase("w") == true && keyToCastleFound == true)
                {
                    BossBattle(sc, map, user, inventory, mrLu, input);
                }
                else
                {
                    map.movePlayer(input);
                }
            }
        }
    }
    
    //Method for creating the fight between the user and Mr Qin
    //@param sc the scanner used for input
    //@param mrQinKilled whether the mrQin is killed or not
    //@param user the user in the battle
    //@param inventory the inventory of the user
    //@param mrQin the enemy the user is fighting
    //@return mrQinKilled whether the mrQin was killed or not
    private static boolean mrQinFight(Scanner sc, boolean mrQinKilled, Hero user, Inventory inventory, Enemy mrQin)
    {
        System.out.println();
        System.out.println("You encountered an enemy!");
        System.out.println("Mr Qin emerges from the bushes!");
        System.out.println();
        System.out.println("Which weapon would you like to use");
        System.out.println("----------------------------------");
        System.out.println("You have these weapons at your disposal");
        System.out.println();
        System.out.println("If you see no weapons availible hit enter to engage with default damage.");
        System.out.println();
        inventory.printWeapons();
        String choice = sc.nextLine();
        int damage = inventory.damageForWeapon(choice);
        if (damage == 0)
        {
            System.out.println("You don't have that weapon!");
            System.out.println("Your default damage is 10");
            System.out.println();
            damage = 10;
        }

        while (mrQin.getHp() >= 0 && user.getHp() >= 0)
        {
            user.attack(mrQin, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (mrQin.getHp() < 0)
            {
                mrQin.setHp(0);
            }
            System.out.println("You attacked the Mr Qin, his new health is " + mrQin.getHp());
            if (mrQin.getHp() == 0) break;
            mrQin.attack(user, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (user.getHp() < 0)
            {
                user.setHp(0);
            }
            System.out.println("You were hit by the Mr Qin, your new health is " + user.getHp());
            if (user.getHp() == 0) break;
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
        }

        if (user.getHp() > mrQin.getHp())
        {
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
            System.out.println();
            System.out.println("Congratulations! You killed Mr Qin!");
            System.out.println("Type any key to return");
            mrQinKilled = true;
        }
        else
        {
            System.out.println();
            System.out.println("You got killed by Mr Qin?");
            System.out.println("That's pretty understandable. but still...");
            System.out.println("Gameover!");
            System.exit(0);
        }
        return mrQinKilled;
    }
    
    //Method for creating the fight between the user and extremely gay Chris
    //@param sc the scanner used for input
    //@param extremelyGayChrisKilled whether the extremelyGayChris is killed or not
    //@param user the user in the battle
    //@param inventory the inventory of the user
    //@param extremelyGayChris the enemy the user is fighting
    //@return extremelyGayChrisKilled whether the extremelyGayChris was killed or not
    private static boolean extremelyGayChristFight(Scanner sc, boolean extremelyGayChrisKilled, Hero user, Inventory inventory, Enemy extremelyGayChris)
    {
        System.out.println();
        System.out.println("You encountered an enemy!");
        System.out.println("The extremely gay chris says something really profane!");
        System.out.println("When you dont respond, he attacks!");
        System.out.println();
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
            System.out.println();
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
            if (extremelyGayChris.getHp() < 0)
            {
                extremelyGayChris.setHp(0);
            }
            System.out.println("You attacked the Really Gay Chris, his new health is " + extremelyGayChris.getHp());
            if (extremelyGayChris.getHp() == 0) break;
            extremelyGayChris.attack(user, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (user.getHp() < 0)
            {
                user.setHp(0);
            }
            System.out.println("You were hit by the Really Gay Chris, your new health is " + user.getHp());
            if (user.getHp() == 0) break;
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
        }

        if (user.getHp() > extremelyGayChris.getHp())
        {
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
            System.out.println();
            System.out.println("Congratulations! You killed the Really Gay Chris");
            System.out.println("Type any key to return");
            extremelyGayChrisKilled = true;
        }
        else
        {
            System.out.println();
            System.out.println("You got killed by Really Gay Chris");
            System.out.println("He says that your body looks scrumptious");
            System.out.println("Gameover!");
            System.exit(0);
        }
        return extremelyGayChrisKilled;
    }
    
    //Method for creating the fight between the user and the feral Crystal
    //@param sc the scanner used for input
    //@param feralCrystalKilled whether the feral Crystal is killed or not
    //@param user the user in the battle
    //@param inventory the inventory of the user
    //@param feralCrystal the enemy the user is fighting
    //@return feralCrystalKilled whether the henchman was killed or not
    private static boolean feralCrystalFight(Scanner sc, boolean feralCrystalKilled, Hero user, Inventory inventory, Enemy feralCrystal)
    {
        System.out.println();
        System.out.println("You encountered an enemy!");
        System.out.println("A feral Crystal awkwardly stares at you!");
        System.out.println("She attacks!");
        System.out.println();
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
            System.out.println();
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
            if (feralCrystal.getHp() < 0)
            {
                feralCrystal.setHp(0);
            }
            System.out.println("You attacked the feral Crystal, her new health is " + feralCrystal.getHp());
            if (feralCrystal.getHp() == 0)
            {
                break;
            }
            feralCrystal.attack(user, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (user.getHp() < 0)
            {
                user.setHp(0);
            }
            if (user.getHp() == 0)
            {
                break;
            }
            System.out.println("You were hit by the feral Crystal, your new health is " + user.getHp());
            if (user.getHp() < 0) break;
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
        }

        if (user.getHp() > feralCrystal.getHp())
        {
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
            System.out.println();
            System.out.println("Congratulations! You killed the feral Crystal!");
            System.out.println("Type any key to return");
            feralCrystalKilled = true;
        }
        else
        {
            System.out.println();
            System.out.println("You got killed by the feral Crystal?");
            System.out.println("Man... she's probably gonna eat your body that sucks.");
            System.out.println("Gameover!");
            System.exit(0);
        }
        return feralCrystalKilled;
    }
    
    //Method for creating the fight between the user and Henchman
    //@param sc the scanner used for input
    //@param henchmanKilled whether the henchman is killed or not
    //@param user the user in the battle
    //@param inventory the inventory of the user
    //@param henchman the enemy the user is fighting
    //@return henchManKilled whether the henchman was killed or not
    private static boolean henchmenFight(Scanner sc, boolean henchmanKilled, Hero user, Inventory inventory, Enemy henchman)
    {
        System.out.println();
        System.out.println("You encountered an enemy!");
        System.out.println("The henchman flips you off!");
        System.out.println();
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
            System.out.println();
            damage = 10;
        }

        while (henchman.getHp() >= 0 && user.getHp() >= 0)
        {
            user.attack(henchman, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (henchman.getHp() < 0)
            {
                henchman.setHp(0);
            }
            System.out.println("You attacked the henchman, his new health is " + henchman.getHp());
            if (henchman.getHp() == 0) break;
            henchman.attack(user, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (user.getHp() < 0)
            {
                henchman.setHp(0);
            }
            System.out.println("You were hit by the henchman, your new health is " + user.getHp());
            if (user.getHp() == 0) break;
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
        }

        if (user.getHp() > henchman.getHp())
        {
            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }
            System.out.println();
            System.out.println("Congratulations! You killed the henchman");
            System.out.println("Type any key to return");
            henchmanKilled = true;
        }
        else
        {
            System.out.println();
            System.out.println("You got killed by a henchman? Wow you suck.");
            System.out.println("Gameover!");
            System.exit(0);
        }
        return henchmanKilled;
    }
    
    //Prints the inventory and prompts user for input
    //@param user the user that is accessing their inventory
    //@param inventory the inventory object of that user
    private static void promptUser(Hero user, Inventory inventory)
    {
        System.out.println("Welcome To Your Inventory | Your Current HP is " + user.getHp() + " hp");
        System.out.println("-----------------------------------------------------");
        inventory.printInventory();
        System.out.println();
        System.out.println("Your bags weight is " + inventory.getCurrentWeight() + "/" + inventory.getCapacity());
        System.out.println();
        System.out.println("If you would like to remove an item from your bag, type 'd'");
        System.out.println("If you would like to close your inventory, hit any other key.");
        System.out.println("If you would like to save your game type 's'");
    }
    
    //Method used for saving the game
    //@param healthPotions an arraylist of health potions to be saved
    //@param map the map containing the coordinates of the player to be saved
    //@param user the hero being saved (hp, name etc)
    //@param inventory the inventory of the user being saved
    //@param dagger a weapon containing x and y coordinates on the map to be saved
    //@param sword a weapon containing x and y coordinates on the map to be saved
    //@param longsword a weapon containing x and y coordinates on the map to be saved
    //@param feralCrystal an enemy being saved
    //@param henchman an enemy being saved
    //@param mrQin an enemy being saved
    //@param extremelyGayChris an enemy being saved
    private static void saveGame(ArrayList<Item> healthPotions, MapOfGame map, Hero user, Inventory inventory, Weapon dagger, Weapon sword, Weapon longsword, Enemy feralCrystal, Enemy henchman, Enemy mrQin, Enemy extremelyGayChris) throws IOException
    {
        System.out.println("We're gonna save your game now.");
        System.out.println();
        FileOutputStream fout = new FileOutputStream("save.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(inventory);
        oos.writeObject(user);
        oos.writeObject(map);
        oos.writeObject(healthPotions);
        oos.writeObject(dagger);
        oos.writeObject(sword);
        oos.writeObject(longsword);
        oos.writeObject(feralCrystal);
        oos.writeObject(henchman);
        oos.writeObject(extremelyGayChris);
        oos.writeObject(mrQin);
        oos.close();
    }
    
    //Method for creating the battle between the player and Mr Lu
    //@param sc the scanner object
    //@param map the map object
    //@param user the hero object
    //@param inventory the inventory object
    //@param enemy the enemy object
    //@param input the string to decide which weapon the user selects
    private static void BossBattle(Scanner sc, MapOfGame map, Hero user, Inventory inventory, Enemy mrLu, String input)
    {
        map.movePlayer(input);
        System.out.println("YOU ENTERED MY CASTLE?!");
        System.out.println("YOUUUU HAVE MADE A GRAAAVVE MISTAKE COMING HERE");
        System.out.println("YOU THINK YOU CAN CHALLENGE ME?!?!");
        System.out.println();
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
            System.out.println();
            damage = 10;
        }

        while (user.getHp() >= 0 && mrLu.getHp() >= 0)
        {

            user.attack(mrLu, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (mrLu.getHp() < 0)
            {
                mrLu.setHp(0);
            }
            System.out.println("You attacked the Mr Lu, his new health is " + mrLu.getHp());

            if (mrLu.getHp() == 0) break;

            mrLu.attack(user, damage);
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (user.getHp() < 0)
            {
                user.setHp(0);
            }
            System.out.println("You were hit by Mr Lu, your new health is " + user.getHp());
            if (user.getHp() == 0) break;

            if (user.getHp() < 30 && inventory.hasItem("Health Potion") == true)
            {
                user.setHp(100);
                System.out.println("You used a health potion, your health has been restored to " + user.getHp() + " hp.");
                inventory.removeItemFromBag("Health Potion");
            }

        }
        if (mrLu.getHp() > user.getHp())
        {
            System.out.println("You got taken out by Mr Lu!");
            System.out.println("Did you even think you had a chance?");
            System.exit(0);
        }
        else
        {
            System.out.println("Congratulations! You beat Mr Lu!");
            System.out.println("You have freed the people of Earth 2 from his tyranny");
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }
    
    //Prints the story
    public static void printStory() throws IOException
    {
        System.out.println();
        System.out.println("In a world known as Earth 2 Humanity is ruled over by one man.");
        System.out.println("This man Vincent Lu has ruled over humanity with his henchmen for centuries.");
        System.out.println("The people of Earth 2 have been far too afraid to challenge Lu due to his immense power.");
        System.out.println("At least they had been, until now");
        System.out.println("What is your name Hero?");
    }
    
    //Prints the instructions on how to play the game
    public static void printInstructions()
    {
        Scanner temp = new Scanner(System.in);
        System.out.println("Your objective is to enter Lu's castle and overthrow him as corrupt leader");
        System.out.println("To do so, you must find the key that is located somewhere on the map");
        System.out.println("This key will allow you to enter his castle and fight him for power over the kingdom");
        System.out.println("But be warned the fight against Lu will not be easy, you will need to be prepared");
        System.out.println("Here are some tips:");
        System.out.println();
        System.out.println("Use, 'N', 'E' ,'S', 'W' to travel around the map (N, for north etc)");
        System.out.println("Hit I to open your inventory to see your various items");
        System.out.println("When in combat select your weapon with the highest damage to have the best odds of winning");
        System.out.println("That's all for now! best of luck to you in freeing the people of Earth 2!");
        System.out.println();
        System.out.println("Wait wait one more thing, are you feeling confident about beating Lu? (Yes/No)");
        String answer = temp.nextLine();
        if (answer.equalsIgnoreCase("yes") == true)
        {
            System.out.println("Hmmm okay we'll see.");
            System.out.println();
        }
        else if (answer.equalsIgnoreCase("no") == true)
        {
            System.out.println("Don't worry! you'll be fine! Probably...");
            System.out.println();
        }
    }
    
    //prints an error message if the user trys to enter the castle without a key
    public static void castleAcessDenied ()
    {
        System.out.println("You can't go there without the key!");
        System.out.println();
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


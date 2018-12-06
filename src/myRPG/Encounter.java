package myRPG;

public class Encounter
{
   private double probability;
   private int randomLocation;
   double temp;
   //Constructor of the class (default values are assigned here)
   public Encounter ()
   {
	   probability = (Math.random()*100);
   }
   //Creates a random location from 1-9
   //@return the random location generated
   public int getRandomLocation ()
   {
	   temp = Math.random()*9;
	   randomLocation = (int) temp;
	   return randomLocation;
   }
}

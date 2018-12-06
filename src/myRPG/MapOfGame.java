package myRPG;

import java.io.Serializable;

public class MapOfGame implements Serializable
{
	private String[][] map = new String[9][9];
	private int xPosOfPlayer;
	private int yPosOfPlayer;      

	public MapOfGame ()
	{
		xPosOfPlayer = 4;
		yPosOfPlayer = 4;
	}
	
	public void getCurrentLocation ()
	{
		System.out.println("Your position is at ["+(xPosOfPlayer+1)+"] , ["+(yPosOfPlayer+1)+"]");
	}
	
	public int getX ()
	{
		return xPosOfPlayer;
	}
	
	public int getY ()
	{
		return yPosOfPlayer;
	}
	
	public void initializeArray()
	{
       for (int i = 0; i < map.length; i++)
       {
    	   for (int j = 0; j< map[0].length; j++)
    	   {
    		   map [i][j] = "O";
    	   }
       }
          map[8][4] = "?";
	}
	
	public void printMap()
	{
		int rowCount = 0;
		map [yPosOfPlayer] [xPosOfPlayer] = "X";
		for (int i = 0; i < map.length; i++)
		{
			if (rowCount == 0)
			{
				System.out.println("     1      2      3      4      5      6      7      8      9");
				System.out.println("");
				System.out.println("     ---------------------------------------------------------");
				System.out.println("");
			}
			    
			rowCount++;
			System.out.print(rowCount + "|");
			
			for (int j = 0; j < map[0].length; j++)
			{
				System.out.print("   " + map[i][j] + "   ");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
	}

	public void movePlayer (String direction)
	{
		if (direction.equalsIgnoreCase("north") == true || direction.equalsIgnoreCase("up") == true || direction.equalsIgnoreCase("n") == true || direction.equalsIgnoreCase("u") == true)
		{
			map [yPosOfPlayer] [xPosOfPlayer] = "O";
			yPosOfPlayer -=1;
			if (yPosOfPlayer < 0)
			{
				yPosOfPlayer++;
				System.out.println("Sorry, you can't go any further north!");
			}
		}
		
		if (direction.equalsIgnoreCase("south") == true || direction.equalsIgnoreCase("down") == true || direction.equalsIgnoreCase("s") == true || direction.equalsIgnoreCase("d") == true)
		{
			map [yPosOfPlayer] [xPosOfPlayer] = "O";
			yPosOfPlayer+=1;				
			if (yPosOfPlayer > 8)
			{
				yPosOfPlayer--;
				System.err.println("Sorry, you can't go any further south!");
			}
		}
		
		if (direction.equalsIgnoreCase("west") == true || direction.equalsIgnoreCase("left") == true || direction.equalsIgnoreCase("w") == true || direction.equalsIgnoreCase("l") == true)
		{
			map [yPosOfPlayer] [xPosOfPlayer] = "O";
			xPosOfPlayer-=1;
			if (xPosOfPlayer < 0)
			{
				xPosOfPlayer++;
				System.out.println("Sorry, you can't go any further west!");
			}
		}
		
		if(direction.equalsIgnoreCase("east") == true || direction.equalsIgnoreCase("right") == true || direction.equalsIgnoreCase("e") == true || direction.equalsIgnoreCase("r") == true)
		{
			map [yPosOfPlayer] [xPosOfPlayer] = "O";
			xPosOfPlayer+=1;
			if (xPosOfPlayer > 8)
			{
				xPosOfPlayer--;
				System.out.println("Sorry, you can't go any further east!");
			}
		}	
	}
}


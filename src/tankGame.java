import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random; 

public class tankGame extends PApplet{
	ArrayList<Tank> enemies;
	Tank hero; 
	int size=10;

	public static void main(String[] args) {
		PApplet.main("tankGame");

	}

	public void settings(){
		size(1024,768);

	}

	public void setup(){
		Random rand = new Random(); 
		enemies= new ArrayList<Tank>();
		for (int i=0;i<size;i++) {
			enemies.add(new Tank(this, ""+i,rand.nextInt(1024),rand.nextInt(768)));

		}
		hero = new Tank(this, "Joe", 50,50 );


	}


	public void draw(){
		background(255);	

		hero.drawTank();
		hero.drawHP();
		
		
		

		for (int i=0;i<size;i++) {
			enemies.get(i).drawTank();
			enemies.get(i).drawHP();
		}


	}
	
	
}
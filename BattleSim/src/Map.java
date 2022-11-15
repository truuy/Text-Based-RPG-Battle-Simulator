import java.util.Scanner;

public class Map {
	
	
	int x;
	int y;
	
	
	int traverseMap()
	{
		int spawn;
		int action = 0;
		displayPosition(x,y);
		System.out.println("(1)North, (2)East, (3)South, (4)West");
		action = inputValidation(1,4);
		
		switch (action)
		{
			case 1:
			{
				y++;
				System.out.println("You moved north.");
				displayPosition(x,y);
				spawn = rollSpawn();
				
				return spawn;
			}
			
			case 2:
			{
				x++;
				System.out.println("You moved east.");
				displayPosition(x,y);
				spawn = rollSpawn();
				return spawn;
			}
			case 3:
			{
				y--;
				System.out.println("You moved south.");
				displayPosition(x,y);
				spawn = rollSpawn();
				return spawn;
			}
			case 4:
			{
				x--;
				System.out.println("You moved west.");
				displayPosition(x,y);
				spawn = rollSpawn();
				return spawn;
			}
		}
		return 0;
	}
	
	int rollSpawn ()
	{
		Dice die = new Dice();
		int spawn;
		//Spawn monster
		spawn = die.rollDie(2);
		return spawn;
	}
	
	void displayPosition(int x, int y)
	{
		System.out.println("Your current position: (" + x + ", " + y + ") \n");
	}
	
	int inputValidation(int low, int hi)
	{
		Scanner scanner = new Scanner (System.in);
		int result;
		while (true) 
		{
		    try {
		        String a  = scanner.next();
		        result = Integer.parseInt(a);
		    } catch(Exception e) {
		        System.out.println("Could not parse input, please try again: ");
		        continue;
		    }

		    if (result < low || result > hi) {
		        System.out.println("Invalid input! Please select a number between " + low + " to " + hi +":");        
		    }else {
		    	return result;
		    } 
		}
	}
}

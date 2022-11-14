import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		String name;
		int selectRace = 0;
		int selectClass = 0;
		
		System.out.println("Simple Battle Simulator made by Troy Ulang (Object Oriented Programming)");
		System.out.println("\n ====== CHARACTER CREATION ====== \n");
		
		//Character name, race, and class input
		System.out.println("Enter your character name: ");
		name = scanner.next();
		System.out.println("Select your race: ");
		System.out.println("(1) Human, (2) Dwarf, (3) Elf, (4) Halfling");
		selectRace = inputValidation(1,4); //input
		System.out.println("Select your class: ");
		System.out.println("(1) Fighter, (2) Ranger, (3) Mage, (4) Priest");
		selectClass = inputValidation(1,4); //input
		
		//Create Player Object and Map
		Player player = new Player(name, 1, 0, 0, 0, 0, 0, 0, 0, selectRace, selectClass);
		Map map = new Map();
		player.createCharacter();
		
		player.showStats();
		
		System.out.println("\n ====== GAME START ====== \n");
		
		//Actions
		while(true)
		{
			
			int action = 0;
			System.out.println("CHOOSE YOUR ACTION");
			System.out.println("(1) Move, (2) Rest, (3) Show Stats, (4) Quit");
			action = inputValidation(1,4);
			
			switch (action)
			{
				//Traverse Map
				case 1:
				{
					map.traverseMap();
					break;
				}
				
				//Player Rest
				case 2:
				{
					
				}
				
				//Show Player Statistics
				case 3:
				{
					player.showStats();
					break;
				}
			}
		}
		
		
		
		
		
		 
		
		
		
	}	
	
	static int inputValidation(int low, int hi)
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

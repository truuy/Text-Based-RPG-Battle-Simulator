import java.util.Scanner;

public class Game {
	
	static Scanner scanner = new Scanner (System.in);
	
	public static void main(String[] args) {
		
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
			int spawnMonster = 0;
			int action = 0;
			System.out.println("CHOOSE YOUR ACTION");
			System.out.println("(1) Move, (2) Rest, (3) Show Stats, (4) Quit");
			action = inputValidation(1,4);
			
			switch (action)
			{
				//Traverse Map
				case 1:
				{
					spawnMonster = map.traverseMap();
					
					if(spawnMonster <= 1)
					{
						break;
					}
					else
					{
						Monsters monster = spawnMonster();
						System.out.println("An enraged "+monster.getName()+" appeared out of nowhere! get ready to fight!!");
						battlePhase(player, monster);
					}		
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
			
			
		}//loop end
	}
	
	static void battlePhase(Player player, Monsters monster)
	{
		
		System.out.println("\n ====== BATTLE PHASE ====== \n");
		
		while (true)
		{
			Dice die = new Dice();
			System.out.println(player.getName() +" HP: "+player.HP);
			System.out.println(monster.getName() +" HP: "+monster.HP);
			
			System.out.println("\nCHOOSE YOUR MOVE");
			System.out.println("(1) Attack, (2) Cast Spells, (3) Show Stats, (4) Run");
			int move = inputValidation(1,4);
			
			switch (move)
			{
				//Attack
				case 1:
				{
					int damage = 0;
					double accuracy = 75;
					double hitRate = 0;
					double enemyEvasion = 0;
					
					//Hit or Miss (i guess you'll never miss huh)
					die.rollDie(100);
					hitRate = (player.DEX * 0.1)*100;
					enemyEvasion = (monster.AGI * 0.1) * 100;
					accuracy = accuracy + (hitRate + enemyEvasion);
					
					
					
					
					
					
					
					damage = (player.baseDMG * player.STR) - monster.VIT;
					System.out.println(player.getName() +" attaked the "+monster.getName() + " for "+ damage +"points!");
					monster.takeDamage(damage);
					continue;
				}
				//Cast Spells
				case 2:
				{
					
				}
				//Show Statistics
				case 3:
				{
					
				}
				//Run
				case 4:
				{
					
				}
			}
			
			break;
		}
	}
	
	static Monsters spawnMonster()
	{
		Dice die = new Dice();
		int spawn;
		spawn = die.rollDie(1, 22);
		
		
		if(spawn >= 1 && spawn <= 5)
		{
			Monsters monster = new Monsters("Skeleton", 1, 13, 0, 1, 1, 1, 1, 0, 1, "Rusty Axe", 100); 
			return monster;
		}
		else if(spawn >= 6 && spawn <= 10)
		{
			Monsters monster = new Monsters("Orc", 2, 20, 0, 2, 2, 1, 1, 0, 1, "Wooden Club",150); 
			return monster;
		}
		else if(spawn >= 11 && spawn <= 15)
		{
			Monsters monster = new Monsters("Goblin", 2, 10, 0, 0, 0, 2, 3, 0, 1, "Dagger", 120); 
			return monster;
		}
		else if(spawn >= 16 && spawn <= 20)
		{
			Monsters monster = new Monsters("Vampire", 3, 15, 0, 1, 1, 1, 3, 0, 1, "Sharp Fang", 150); 
			return monster;
		}
		
		else
		{
			Monsters monster = new Monsters("Stone Golem", 10, 30, 0, 5, 1, 1, 5, 0, 1, "Rock Smash", 500);
			return monster;
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

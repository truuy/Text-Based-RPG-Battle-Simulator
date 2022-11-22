import java.util.Scanner;

public class Game {
	
	static boolean gameStart = true;
	
	static Scanner scanner = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Dice die = new Dice();
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
		Player player = new Player(name, 1, 0, 0, 0, 0, 0, 0, 0, 0, selectRace, selectClass);
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
						break;
					}		
				}
				
				//Player Rest
				case 2:
				{
					int rest = die.rollDie(2);
					if (rest == 1)
					{
						System.out.println("You are well rested..");
						player.refreshHP();
						break;
					}
					else
					{
						Monsters monster = spawnMonster();
						System.out.println("An enraged "+monster.getName()+" appeared out of nowhere! get ready to fight!!");
						battlePhase(player, monster);
						break;
					}
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
			System.out.println(" ");
			System.out.println(player.getName() +" HP: "+player.HP);
			System.out.println(monster.getName() +" HP: "+monster.HP);
			
			System.out.println("\nCHOOSE YOUR MOVE");
			System.out.println("(1) Attack, (2) Show Stats, (3) Run");
			int move = inputValidation(1,3);
			
			switch (move)
			{
				//Attack
				case 1:
				{
					dealDamage(player, monster);
					takeDamage(player, monster);
					
					if(monster.HP <= 0)
					{
						if(monster.getName() == "Stone Golem")
						{
							System.out.println("The "+monster.getName()+" has been finally slained. Your adventure ends here.");
							monster = null;
							System.out.println("\n ====== GAME OVER ====== \n");
							break;
						}
						else
						{
							System.out.println("The "+monster.getName()+" has been slained. Gained "+monster.addExp()+" exp.");
							player.levelUp(monster.addExp());
							monster = null;
							System.out.println("\n ====== END OF BATTLE ====== \n");
							break;
						}
						
					}
					
					isPlayerDead(player);
					continue;
			
				}

				//Show Statistics
				case 2:
				{
					monster.showStats();
					continue;
				}
				//Run
				case 3:
				{
					Dice die = new Dice();
					int run = die.rollDie(2);
					if (run == 2)
					{
						System.out.println("Run failed.");
						takeDamage(player, monster);
						isPlayerDead(player);
						continue;
					}
					else
					{
						System.out.println("Run succesful.");
						break;
					}
				}
			}
			
			break;
		}
	}
	
	static void isPlayerDead(Player player)
	{
		boolean isPlayerDead = false;
		if(player.HP <= 0)
		{
			isPlayerDead = true;
		}
		
		if(isPlayerDead == true)
		{
			System.out.println("You have been slained.");
			player = null;
			System.out.println("\n ====== GAME OVER ====== \n");
			System.exit(0);
		}
		else
		{
			
		}
		
		
	}
	
	static void dealDamage(Player player, Monsters monster)
	{
		Dice die = new Dice();
		int damage = 0;
		double critChance = 5;
		int critDmg = 0;
		double critBns = 0;
		double accuracy = 55;
		double hitRate = 0;
		double enemyEvasion = 0;
		
		//Hit or Miss (i guess you'll never miss huh)
		int dieResult = die.rollDie(100);
		hitRate = (player.DEX * 0.1)*100;
		enemyEvasion = (monster.AGI * 0.1) * 100;
		accuracy = accuracy + (hitRate - enemyEvasion);
		damage = (player.baseDMG * player.STR) - monster.VIT;
		critChance = Math.ceil(critChance * player.DEX);
		critBns = Math.ceil(damage * 0.50);
		critDmg = damage + (int)critBns;
		
		//Clamp the accuracy to max 80
		if(accuracy > 80)
		{
			accuracy = 80;
		}
		System.out.println("\nAccuracy: "+accuracy);
		if (dieResult <= accuracy)
		{
			int critRoll = die.rollDie(100);
			if(critRoll <= critChance) 
			{
				System.out.println(player.getName() +" attacked the "+monster.getName() + " with a "+player.weapon+" for "+ critDmg +"points! Critical hit!\n");
				monster.takeDamage(critDmg);
				
			}
			else
			{
				System.out.println(player.getName() +" attacked the "+monster.getName() + " with a "+player.weapon+ " for "+ damage +"points!");
				monster.takeDamage(damage);
			}
		}
		else
		{
			System.out.println("Your attack missed.");
		}
	}
	
	static void takeDamage(Player player, Monsters monster)
	{
		Dice die = new Dice();
		int damage = 0;
		double critChance = 5;
		int critDmg = 0;
		double critBns = 0;
		double accuracy = 55;
		double hitRate = 0;
		double enemyEvasion = 0;
		
		//Hit or Miss (i guess you'll never miss huh)
		int dieResult = die.rollDie(100);
		hitRate = (monster.DEX * 0.1)*100;
		enemyEvasion = (player.AGI * 0.1) * 100;
		accuracy = accuracy + (hitRate - enemyEvasion);
		damage = (monster.baseDMG * monster.STR) - player.VIT;
		critChance = Math.ceil(critChance * monster.DEX);
		critBns = Math.ceil(damage * 0.50);
		critDmg = damage + (int)critBns;
		
		//Clamp the accuracy to max 80
		if(accuracy > 80)
		{
			accuracy = 80;
		}
		
		//If damage is lower than 0, replace with 1 as minimum
		if(damage <= 0)
		{
			damage = 1;
		}
	
		System.out.println("\nAccuracy: "+accuracy);
		if (dieResult <= accuracy)
		{
			int critRoll = die.rollDie(100);
			if(critRoll <= critChance) 
			{
				System.out.println(monster.getName() +" attacked "+player.getName() + " with a "+monster.weapon+" for "+ critDmg +"points! Critical hit!\n");
				player.takeDamage(critDmg);
				
			}
			else
			{
				System.out.println(monster.getName() +" attacked "+player.getName() + " with a "+monster.weapon+ " for "+ damage +"points!");
				player.takeDamage(damage);
			}
		}
		else
		{
			System.out.println(monster.getName() + "'s attack missed.");
		}
	}
	
	static Monsters spawnMonster()
	{
		Dice die = new Dice();
		int spawn;
		spawn = die.rollDie(1, 22);
		
		//Spawn Monster
		if(spawn >= 1 && spawn <= 5)
		{
			Monsters monster = new Monsters("Skeleton", 2, 13, 13, 0, 2, 1, 1, 1, 0, 1, "Rusty Axe", 10); 
			return monster;
		}
		else if(spawn >= 6 && spawn <= 10)
		{
			Monsters monster = new Monsters("Orc", 2, 20, 20, 0, 3, 2, 1, 1, 0, 1, "Wooden Club",15); 
			return monster;
		}
		else if(spawn >= 11 && spawn <= 15)
		{
			Monsters monster = new Monsters("Goblin", 2, 10, 10, 0, 0, 0, 2, 3, 0, 1, "Dagger", 10); 
			return monster;
		}
		else if(spawn >= 16 && spawn <= 20)
		{
			Monsters monster = new Monsters("Vampire", 3, 15, 15, 0, 1, 1, 1, 3, 0, 1, "Sharp Fang", 13); 
			return monster;
		}
		
		else
		{
			Monsters monster = new Monsters("Stone Golem", 10, 30, 30, 0, 5, 1, 1, 5, 0, 20, "Rock Smash", 50);
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

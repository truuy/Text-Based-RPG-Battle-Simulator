
public class Player extends Actors{
	
	int raceCode;
	int classCode;
	int exp;
	int level;
	int gold;
	String weapon;
	String race;
	String pclass;
	
	
	//Constructor
	Player(String name, int baseDMG, int HP, int MP, int STR, int VIT, int DEX, int AGI, int INT, int raceCode, int classCode) {
		super(name, baseDMG, HP, MP, STR, VIT, DEX, AGI, INT);
		
		this.name = name;
		this.baseDMG = baseDMG;
		this.HP = HP;
		this.MP = MP;
		this.STR = STR;
		this.VIT = VIT;
		this.DEX = DEX;
		this.AGI = AGI;
		this.INT = INT;
		this.raceCode = raceCode;
		this.classCode = classCode;
	}
	
	
	
	String getName()
	{
		return name + " (lvl" + level +")";
	}
	
	int getHP()
	{
		return HP;
	}
	
	void createCharacter()
	{
		if(raceCode == 1 && classCode == 1)
		{
			race = "Human";
			pclass = "Fighter";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 0;
			STR = 5;
			VIT = 3;
			DEX = 2;
			AGI = 1;
			INT = 0;
			weapon = "Greatsword";
		}
		else if(raceCode == 1 && classCode == 2)
		{
			race = "Human";
			pclass = "Ranger";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 3;
			STR = 3;
			VIT = 0;
			DEX = 5;
			AGI = 2;
			INT = 2;
			weapon = "Crossbow";
		}
		else if(raceCode == 1 && classCode == 3)
		{
			race = "Human";
			pclass = "Mage";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 7;
			STR = 1;
			VIT = 0;
			DEX = 2;
			AGI = 2;
			INT = 5;
			weapon = "Cedar Staff";
		}
		else if(raceCode == 1 && classCode == 4)
		{
			race = "Human";
			pclass = "Priest";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 18;
			MP = 5;
			STR = 3;
			VIT = 3;
			DEX = 0;
			AGI = 3;
			INT = 3;
			weapon = "Holy Bible";
		}
		
		else if(raceCode == 2 && classCode == 1)
		{
			race = "Dwarf";
			pclass = "Fighter";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 18;
			MP = 0;
			STR = 7;
			VIT = 2;
			DEX = 1;
			AGI = 3;
			INT = 0;
			weapon = "Battle Axe";
		}
		else if(raceCode == 2 && classCode == 2)
		{
			race = "Dwarf";
			pclass = "Ranger";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 18;
			MP = 3;
			STR = 2;
			VIT = 0;
			DEX = 3;
			AGI = 2;
			INT = 2;
			weapon = "Short Bow";
		}
		else if(raceCode == 2 && classCode == 3)
		{
			race = "Dwarf";
			pclass = "Mage";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 3;
			STR = 1;
			VIT = 0;
			DEX = 1;
			AGI = 2;
			INT = 3;
			weapon = "Club";
		}
		else if(raceCode == 2 && classCode == 4)
		{
			race = "Dwarf";
			pclass = "Priest";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 3;
			STR = 1;
			VIT = 2;
			DEX = 0;
			AGI = 1;
			INT = 3;
			weapon = "Scepter";
		}
		
		else if(raceCode == 3 && classCode == 1)
		{
			race = "Elf";
			pclass = "Fighter";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 5;
			STR = 3;
			VIT = 1;
			DEX = 1;
			AGI = 1;
			INT = 0;
			weapon = "Short Sword";
		}
		else if(raceCode == 3 && classCode == 2)
		{
			race = "Elf";
			pclass = "Ranger";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 13;
			MP = 5;
			STR = 2;
			VIT = 0;
			DEX = 3;
			AGI = 3;
			INT = 1;
			weapon = "Dagger";
		}
		else if(raceCode == 3 && classCode == 3)
		{
			race = "Elf";
			pclass = "Mage";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 8;
			STR = 1;
			VIT = 0;
			DEX = 3;
			AGI = 3;
			INT = 7;
			weapon = "Black Crystal";
		}
		else if(raceCode == 3 && classCode == 4)
		{
			race = "Elf";
			pclass = "Priest";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 5;
			STR = 2;
			VIT = 2;
			DEX = 0;
			AGI = 2;
			INT = 2;
			weapon = "Tome";
		}
		
		else if(raceCode == 4 && classCode == 1)
		{
			race = "Halfling";
			pclass = "Fighter";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 0;
			STR = 3;
			VIT = 2;
			DEX = 2;
			AGI = 2;
			INT = 0;
			weapon = "Club";
		}
		else if(raceCode == 4 && classCode == 2)
		{
			race = "Halfling";
			pclass = "Ranger";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 0;
			STR = 5;
			VIT = 0;
			DEX = 7;
			AGI = 3;
			INT = 0;
			weapon = "Hunting Bow";
		}
		else if(raceCode == 4 && classCode == 1)
		{
			race = "Halfling";
			pclass = "Mage";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 13;
			MP = 5;
			STR = 1;
			VIT = 0;
			DEX = 2;
			AGI = 2;
			INT = 3;
			weapon = "Wand";
			
		}
		else if(raceCode == 4 && classCode == 1)
		{
			race = "Halfling";
			pclass = "Priest";
			exp = 0;
			level = 1;
			gold = 0;
			HP = 15;
			MP = 3;
			STR = 2;
			VIT = 2;
			DEX = 0;
			AGI = 2;
			INT = 1;
			weapon = "Silver Staff";
		}
		
	}
	
	void showStats()
	{
		System.out.println("\n ====== CHARACTER STATS ====== \n");
		System.out.println(" --INFO-- ");
		System.out.println("Name:		"		+name);
		System.out.println("Race:		"		+race);
		System.out.println("Class:		"		+pclass);
		System.out.println("LVL:		"		+level);
		System.out.println("EXP:		"		+exp);
		System.out.println("GLD:		"		+gold);
		System.out.println("--STATS--");
		System.out.println("HP:		"			+HP);
		System.out.println("MP:		"			+MP);
		System.out.println("Base Damage:	"	+baseDMG);
		System.out.println("STR:		"		+STR);
		System.out.println("VIT:		"		+VIT);
		System.out.println("DEX:		"		+DEX);
		System.out.println("AGI:		"		+AGI);
		System.out.println("INT:		"		+INT);
		System.out.println("Weapon:		"		+weapon);
	}
	
	
	
}

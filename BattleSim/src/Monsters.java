
public class Monsters extends Actors {
	
	int level;
	int expReward;
	
	String weapon;
	
	//Constructor
	Monsters(String name, int baseDMG, int HP, int maxHP, int MP, int STR, int VIT, int DEX, int AGI, int INT, int level, String weapon, int expReward) {
		super(name, baseDMG, HP, maxHP, MP, STR, VIT, DEX, AGI, INT);
		
		this.name = name;
		this.name = name;
		this.baseDMG = baseDMG;
		this.HP = HP;
		this.MP = MP;
		this.STR = STR;
		this.VIT = VIT;
		this.DEX = DEX;
		this.AGI = AGI;
		this.INT = INT;
		this.level = level;
		this.weapon = weapon;
		this.expReward = expReward;
	}
	
	int addExp()
	{
		return expReward;
	}
	
	String getName()
	{
		return name + " (lv." + level +")";
	}
	
	int getHP()
	{
		return HP;
	}
	
	void takeDamage(int damage)
	{
		HP = HP - damage;
	}
	
	void showStats()
	{
		System.out.println("\n ====== CHARACTER STATS ====== \n");
		System.out.println(" --INFO-- ");
		System.out.println("Name:		"		+name);
		System.out.println("LVL:		"		+level);
		System.out.println("--STATS--");
		System.out.println("HP:		"			+HP);
		System.out.println("HP:		"			+maxHP);
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

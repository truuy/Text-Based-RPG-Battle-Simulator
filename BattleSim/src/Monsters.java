
public class Monsters extends Actors {
	
	int level;
	int expReward;
	int goldReward;
	String weapon;
	
	//Constructor
	Monsters(String name, int baseDMG, int HP, int MP, int STR, int VIT, int DEX, int AGI, int INT, int level, String weapon, int expReward, int goldReward) {
		super(name, baseDMG, HP, MP, STR, VIT, DEX, AGI, INT);
		
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
		this.goldReward = goldReward;
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

}

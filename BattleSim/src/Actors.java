public abstract class Actors {
	
	String name;
	int baseDMG = 1;
	int HP = 0;
	int MP = 0;
	int STR = 0;
	int VIT = 0;
	int DEX = 0;
	int AGI = 0;
	int INT = 0;
	
	
	Actors(String name, int baseDMG, int HP, int MP, int STR, int VIT,
			int DEX, int AGI, int INT)
	{
		this.baseDMG = baseDMG;
		this.name = name;
		this.HP = HP;
		this.MP = MP;
		this.STR = STR;
		this.VIT = VIT;
		this.DEX = DEX;
		this.AGI = AGI;
		this.INT = INT;
	}
	
	
}

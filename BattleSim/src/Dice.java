import java.util.Random;

public class Dice {
	
	int rollDie(int lo, int hi)
	{
		Random random = new Random();
		
		int dice = random.nextInt(lo,hi);
		
		return dice;
	}
	
	int rollDie(int range)
	{
		Random random = new Random();
		
		int dice = random.nextInt(range) + 1;
		
		return dice;
	}

}

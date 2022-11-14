import java.util.Scanner;

public class Map {
	int x;
	int y;
	
	void traverseMap()
	{
		
		int action = 0;
		displayPosition(x,y);
		System.out.println("(1)North, (2)East, (3)South, (4)West");
		action = inputValidation(1,4);
		
		switch (action)
		{
			case 1:
			{
				y++;
				displayPosition(x,y);
				break;
			}
			case 2:
			{
				x++;
				displayPosition(x,y);
				break;			
			}
			case 3:
			{
				y--;
				displayPosition(x,y);
				break;
			}
			case 4:
			{
				x--;
				displayPosition(x,y);
				break;
			}
		}
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

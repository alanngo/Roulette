import java.util.*;
public class Main 
{
	static Scanner in = new Scanner(System.in);
	static void testGame()
	{
		Counter trials = new Counter();
		Wheel wheel = new Wheel();
		System.out.print("Enter the trial runs ");
		int trialRuns = in.nextInt();
		System.out.print("Enter a spin result ");
		int spinResult= in.nextInt();
		for (int i=0; i<trialRuns; i++)
		{
			wheel.spin();
			trials.increment();
			while (wheel.getResult()!=spinResult)
			{
				wheel.spin();
				trials.increment();
			}
			System.out.println("You need to spin the wheel "+trials.getCountInt()+" times to win a single bet");
			trials.reset();
		}
	}
	static void displayTable()
	{
		/**/System.out.print("   ");
		for (int i=3; i<=36; i+=3)
		{
			System.out.print(i +"   ");
		}
		System.out.println();
		System.out.print("0  ");
		for (int i=2; i<=36; i+=3)
		{
			System.out.print(i +"   ");
		}
		System.out.println();
		/**/System.out.print("   ");
		for (int i=1; i<=36; i+=3)
		{
			System.out.print(i +"   ");
		}
		System.out.println();
	}
	static void runGame()
	{
		//initialize game
		Wheel wheel = new Wheel();
		System.out.print("Start by putting money into the game");
		double credit = in.nextDouble();
		Customer customer = new Customer(credit);
		Game game= new Game();
		displayTable();
		while(customer.account().hasMoney())
		{
			System.out.println(customer.account());
			System.out.print("Make a bet: ");
			double bet=in.nextInt();
			
			game.menu();
			
			System.out.print("Choose a bet type");
			int type = in.nextInt();
			game.handleOptions(customer, wheel, bet, type);
		}
	}
	public static void main(String[] args) 
	{
		runGame();
	}
}//end of class

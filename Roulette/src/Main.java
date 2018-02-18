import java.util.*;
public class Main 
{
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) 
	{
		//initialize game
		Wheel wheel = new Wheel();
		System.out.print("Start by putting money into the game");
		double credit = in.nextDouble();
		Customer customer = new Customer(credit);
		Game game= new Game();
		
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
}//end of class

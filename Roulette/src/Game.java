import java.util.*;
public class Game 
{
	private Scanner in;
	public Game()
	{
		in = new Scanner(System.in);
	}
	 void menu()
	{
		System.out.println("1. single bet");
		System.out.println("2. multiple bet");
		System.out.println("3. odd/even bet");
		System.out.println("4. hi/lo bet");
		System.out.println("5. red/black bet");
		System.out.println("6. dozen bet");
		System.out.println("7. row bet");
	}//end of menu
	 void displayResult(Wheel wheel)
	{
		System.out.println("Result: "+wheel.getResult());
	}
	 void displayResult(Wheel wheel, int num)
	{
		System.out.println("Your number: "+num);
		System.out.println("Result: "+wheel.getResult());
	}
	  void displayResult(Wheel wheel, int[] numSet)
	{	
		System.out.println("Your numbers: ");
		for(int i=0; i<numSet.length; i++)
		{
			System.out.print(numSet[i]+" ");
		}
		System.out.println("Result: "+wheel.getResult());
	}
	
	  void singleBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("Choose a number: ");
		int num=in.nextInt();
		wheel.spin();
		customer.bet(wheel, bet, num);
		displayResult(wheel, num);
	}
	  void multipleBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("How many numbers do you want to bet on? ");
		int size=in.nextInt();
		int[] numSet=new int[size];
		for (int i=0; i<numSet.length; i++)
		{
			System.out.print("Choose a number: ");
			numSet[i]=in.nextInt();
		}
		wheel.spin();
		customer.bet(wheel, bet, numSet);
		displayResult(wheel, numSet);
	}
	  void oddEvenBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("1.)Odd or 2.)Even? ");
		int choice = in.nextInt();
		switch (choice)
		{
		case 1:
			wheel.spin();
			customer.betOdd(wheel, bet);
			break;
		case 2:
			wheel.spin();
			customer.betEven(wheel, bet);
			break;
		}
		displayResult(wheel);
	}
	  void hiLoBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("1.)1-18 or 2.)19-36? ");
		int choice = in.nextInt();
		switch (choice)
		{
		case 1:
			wheel.spin();
			customer.betLow(wheel, bet);
			break;
		case 2:
			wheel.spin();
			customer.betHigh(wheel, bet);
			break;
		}
		displayResult(wheel);
	}
	  void redBlackBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("1.)Red or 2.)Black? ");
		int choice = in.nextInt();
		switch (choice)
		{
		case 1:
			wheel.spin();
			customer.betRed(wheel, bet);
			break;
		case 2:
			wheel.spin();
			customer.betBlack(wheel, bet);
			break;
		}
		displayResult(wheel);
	}
	  void dozenBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("1.)st [1-12] 2.)nd? [13-24] 3.)rd [25-36]");
		int choice = in.nextInt();
		switch (choice)
		{
		case 1:
			wheel.spin();
			customer.betFirstTwelve(wheel, bet);
			break;
		case 2:
			wheel.spin();
			customer.betSecondTwelve(wheel, bet);
			break;
		case 3:
			wheel.spin();
			customer.betThirdTwelve(wheel, bet);
			break;
		}
		displayResult(wheel);
	}
	  void rowBet(Customer customer, Wheel wheel, double bet) throws NegativeBalanceException
	{
		System.out.print("1.)st 1,4,7...34 2.)nd? 2,5,8...35 3.)rd 3,6,9...36");
		int choice = in.nextInt();
		switch (choice)
		{
		case 1:
			wheel.spin();
			customer.betFirstRow(wheel, bet);
			break;
		case 2:
			wheel.spin();
			customer.betSecondRow(wheel, bet);
			break;
		case 3:
			wheel.spin();
			customer.betThirdRow(wheel, bet);
			break;
		}
		displayResult(wheel);
	}
	
	  void handleOptions(Customer customer, Wheel wheel, double bet, int option)
	{
		try
		{
			switch(option)
			{
				case 1:
					singleBet(customer, wheel, bet);
					break;
				case 2:
					multipleBet(customer, wheel, bet);
					break;
				case 3:
					oddEvenBet(customer, wheel, bet);
					break;
				case 4:
					hiLoBet(customer, wheel, bet);
					break;
				case 5:
					redBlackBet(customer, wheel, bet);
					break;
				case 6:
					dozenBet(customer, wheel, bet);
					break;
				case 7:
					rowBet(customer, wheel, bet);
					break;
			}
		}
		catch(NegativeBalanceException n)
		{
			System.out.println("Insufficient funds");
		}
		
	}

}

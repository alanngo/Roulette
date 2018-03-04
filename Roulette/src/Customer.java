import java.util.*;
public class Customer 
{
	private Account acc;
	private Scanner in;
	public Customer(double balance)
	{
		acc = new Account(balance);
		in = new Scanner(System.in);
	}
	public Account account()
	{
		return acc;
	}
	
	//all betting options
	public void bet(Wheel wheel, double bet, int key) throws NegativeBalanceException//bets on a single square
	{
		acc.withdraw(bet);
		if(key == wheel.getResult())
		{
			acc.deposit((35*bet)+bet); //35x1 payout
		}
	}
	public void bet(Wheel wheel, double bet, int[] set) throws NegativeBalanceException//bets on a specific set generated by the user
	{
		acc.withdraw(bet*set.length);
		for (int i=0; i<set.length; i++)
		{
			if (set[i]==wheel.getResult())
			{
				acc.deposit((35*bet)+bet); //35x1 payout
			}
		}
	}
	
	public void betOdd(Wheel wheel, double bet) throws NegativeBalanceException//bets on the odd numbers
	{
		acc.withdraw(bet);
		if (wheel.getResult()%2!=0)
		{
			acc.deposit(2*bet); //1x1 payout
		}
	}
	public void betEven(Wheel wheel, double bet) throws NegativeBalanceException//bets on the even number
	{
		acc.withdraw(bet);
		if (wheel.getResult()%2==0)
		{
			acc.deposit(2*bet); //1x1 payout
		}
	}
	
	public void betLow(Wheel wheel, double bet) throws NegativeBalanceException//for cases 1-18
	{
		acc.withdraw(bet);
		if(wheel.getResult()>=1 && wheel.getResult()<=18)
		{
			acc.deposit(2*bet);// 1x1 payout
		}
	}
	public void betHigh(Wheel wheel, double bet) throws NegativeBalanceException//for cases 19-36
	{
		acc.withdraw(bet);
		if(wheel.getResult()>=19 && wheel.getResult()<=36)
		{
			acc.deposit(2*bet);// 1x1 payout
		}
	}
	
	public void betRed(Wheel wheel, double bet) throws NegativeBalanceException//red numbers
	{
		acc.withdraw(bet);
		int [] rNum={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		for (int i=0; i<rNum.length; i++)
		{
			if(wheel.getResult()==rNum[i])
			{
				acc.deposit(2*bet); //1x1 payout
			}
		}
		
	}
	public void betBlack(Wheel wheel, double bet) throws NegativeBalanceException//black numbers
	{
		acc.withdraw(bet);
		int [] bNum={2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
		for (int i=0; i<bNum.length; i++)
		{
			if(wheel.getResult()==bNum[i])
			{
				acc.deposit(2*bet); //1x1 payout
			}
		}
	}
	
	public void betThirdTwelve(Wheel wheel, double bet)throws NegativeBalanceException //bets on 25-36 
	{
		acc.withdraw(bet);
		if(wheel.getResult()>=25 && wheel.getResult()<=36)
		{
			acc.deposit((2*bet)+bet);// 2x1 payout
		}
	}
	public void betSecondTwelve(Wheel wheel, double bet)throws NegativeBalanceException //bets on 13-24 
	{
		acc.withdraw(bet);
		if(wheel.getResult()>=13 && wheel.getResult()<=24)
		{
			acc.deposit((2*bet)+bet);// 2x1 payout
		}
	}
	public void betFirstTwelve(Wheel wheel, double bet)throws NegativeBalanceException //bets on 1-12 
	{
		acc.withdraw(bet);
		if(wheel.getResult()>=1 && wheel.getResult()<=12)
		{
			acc.deposit((2*bet)+bet);// 2x1 payout
		}
	}

	public void betThirdRow(Wheel wheel, double bet) throws NegativeBalanceException//bets on 3, 6, 9....36
	{
		acc.withdraw(bet);
		if (wheel.getResult()%3==0)
		{
			acc.deposit((2*bet)+bet);// 2x1 payout
		}
	}
	public void betSecondRow(Wheel wheel, double bet) throws NegativeBalanceException//bets on 2, 5, 8....35
	{
		acc.withdraw(bet);
		if ((wheel.getResult()+1)%3==0)
		{
			acc.deposit((2*bet)+bet);// 2x1 payout
		}
	}
	public void betFirstRow(Wheel wheel, double bet) throws NegativeBalanceException//bets on 1, 4, 7....34
	{
		acc.withdraw(bet);
		if ((wheel.getResult()+2)%3==0)
		{
			acc.deposit((2*bet)+bet);// 2x1 payout
		}
	}
	
	public void betGreen(Wheel wheel, double bet, int choice) throws NegativeBalanceException //[0,2] or [2,3]
	{
		boolean firstThree = ((choice==1) && ((wheel.getResult()==0)||(wheel.getResult()>=1 && wheel.getResult()<=2)));
		boolean secondThree = ((choice==2) && ((wheel.getResult()==0)||(wheel.getResult()>=2 && wheel.getResult()<=3)));
	
		acc.withdraw(bet);
		if (firstThree||secondThree)
		{
			acc.deposit((6*bet)+bet); //6x1 payout
		}
	}
	
	public void betSplit(Wheel wheel, double bet, int choice, int adjacent) throws NegativeBalanceException
	{//TODO
		int adjacency= choice - adjacent;
		if (adjacency==-3||adjacency==3||adjacency==-1||adjacency==1)//correct case
		{
			if ((choice%3==0 && (adjacent+2)%3==0)||((choice+2)%3==0 && adjacent%3==0))//check cases like 3 and 4
			{
				System.out.println("NO ADJACENCY DETECTED!");
				System.out.print("Enter "+(choice-1)+","+(choice+1)+","+(choice-3)+","+(choice+3));
				adjacent= in.nextInt();
				betSplit(wheel, bet, choice, adjacent);
			}
			else
			{
				acc.withdraw(bet);
				if (wheel.getResult()==choice||wheel.getResult()==adjacent)
				{
					acc.deposit((17*bet)+bet);//pays 17x1
				}
				return;
			}
		}
		 else if (choice==adjacent)//if they pick the same square
		{
			System.out.println("YOUR CHOICE CANNOT BE = TO ADJACENT!");
			System.out.print("Enter "+(choice-1)+","+(choice+1)+","+(choice-3)+","+(choice+3));
			adjacent= in.nextInt();
			betSplit(wheel, bet, choice, adjacent);
		}
		else if (choice<=0||adjacent<=0)//choice is either 0 or out of bounds
		{
			System.out.println("YOUR CHOICE CANNOT BE EITHER NEGATIVE OR 0!");
			System.out.print("Enter a different choice");
			choice= in.nextInt();
			System.out.print("Enter "+(choice-1)+","+(choice+1)+","+(choice-3)+","+(choice+3));
			adjacent= in.nextInt();
			betSplit(wheel, bet, choice, adjacent);
		}
		else if (choice>36||adjacent>36)//out of bounds case greater than 36
		{
			System.out.println("YOUR CHOICE IS GREATER THAN 36!");
			System.out.print("Enter a different choice");
			choice= in.nextInt();
			System.out.print("Enter "+(choice-1)+","+(choice+1)+","+(choice-3)+","+(choice+3));
			adjacent= in.nextInt();
			betSplit(wheel, bet, choice, adjacent);
		}

		else if (adjacency!=-3||adjacency!=3||adjacency!=-1||adjacency!=1)//not adjacent case
		{
			System.out.println("NO ADJACENCY DETECTED!");
			System.out.print("Enter "+(choice-1)+","+(choice+1)+","+(choice-3)+","+(choice+3));
			adjacent= in.nextInt();
			betSplit(wheel, bet, choice, adjacent);
		}
		else//some really weird case AKA SHOULD NEVER GO HERE!
		{
			System.out.print("ERROR! Re enter your bet!");
			choice= in.nextInt();
			System.out.print("Enter the next adjacent");
			adjacent = in.nextInt();
			betSplit(wheel, bet, choice, adjacent);
		}
	}
	public void betCorner(Wheel wheel, double bet, int choice, int adj1, int adj2, int diagonal)throws NegativeBalanceException
	{//TODO
		boolean correctDiagonal = ((diagonal==choice+4||diagonal==choice-4)||(diagonal==choice+2||diagonal==choice-2));
		boolean correctAdjacent1 = (adj1== choice+1&&adj2==choice+3)||(adj1== choice+3||adj1==choice-3);
		boolean correctAdjacent2 = (adj2== choice+1||adj2==choice-1)||(adj2== choice+3||adj2==choice-3);
		boolean positiveEntries = (choice>=0 && adj1>=0 &&adj2>=0 && diagonal>=0);
		boolean differentAdjacent = (adj1!=adj2);
		if ((correctDiagonal&&correctAdjacent1&&correctAdjacent2)&&positiveEntries&&differentAdjacent)
		{
			acc.withdraw(bet);
			if (wheel.getResult()==choice||wheel.getResult()==adj1||wheel.getResult()==adj2||wheel.getResult()==diagonal)
			{
				acc.deposit((8*bet)+bet);//pays 8x1
			}
			return;
		}
		else
		{
			System.out.println("ERROR! INCORRECT ENTRIES!");
			System.out.print("Enter your choice again ");
			choice=in.nextInt();
			System.out.print("Enter adjacent1 again "+(choice+1)+" or "+(choice-1)+" or "+(choice+3)+" or "+(choice-3));
			adj1=in.nextInt();
			System.out.print("Enter adjacent2 again "+(choice+1)+" or "+(choice-1)+" or "+(choice+3)+" or "+(choice-3));
			adj2=in.nextInt();
			System.out.print("Enter diagonal again "+(choice+2)+" or "+(choice-2)+" or "+(choice+4)+" or "+(choice-4));
			diagonal=in.nextInt();
			betCorner(wheel, bet, choice, adj1, adj2, diagonal);
		}
	}
	public String toString()
	{
		return "Balance: "+acc.getBalance()+"\n";
	}
}//end of class

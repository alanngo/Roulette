
public class Counter 
{
	private int count;//integer count
	private double countDouble; //double count
	
	public Counter()//constructor
	{
		count=0;
		countDouble=0;
	}//end of constructor
	
	
	//get
	public int getCountInt()
	{
		return count;
	}
	public double getCountDouble()
	{
		return countDouble;
	}
	
	//set
	public void increment()//increment by 1
	{
		count++;
	}
	public void increment(int amt)//increment by amount
	{
		count+=amt;
	}
	public void decrement()//decrement by 1
	{
		count--;
	}
	public void decrement(int amt)//decrement by amount
	{
		count-=amt;
	}
	
	//set double

	public void incrementDouble(double amt)//increment by amount
	{
		countDouble+=amt;
	}
	public void decrementDouble(double amt)//decrement by amount
	{
		countDouble-=amt;
	}

	public void reset()
	{
		count=0;
		countDouble=0;
	}
}

	

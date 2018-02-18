import java.util.*;
public class Wheel 
{
	private Random rand;
	private int result;
	
	public Wheel()
	{
		rand= new Random();
		result=0;
	}
	public void spin()
	{
		result= rand.nextInt(36);
	}
	public int getResult()
	{
		return result;
	}
}

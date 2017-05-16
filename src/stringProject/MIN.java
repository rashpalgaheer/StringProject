package stringProject;

import java.util.concurrent.CountDownLatch;

public class MIN 
{
	void calMoves()
	{
		int[] a = {1234 , 4321};
		int[] m = {2345, 3214};
		int counter = 0;
		for(int i =0;i<a.length;i++)
		{
			int temp_a = a[i];
			int temp_m = m[i];
			
			while(temp_a > 0)
			{
				int num_a = temp_a %10;
				
				int num_m = temp_m %10;
				
				temp_a = temp_a / 10;
				temp_m = temp_m / 10;
				
			 counter += Math.abs(num_a - num_m);
			}
		}
		System.out.println(counter);
	}
	
	public static void main(String s[])
	{
		MIN m = new MIN();
		m.calMoves();
	}

}

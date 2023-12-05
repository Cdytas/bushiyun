package number6;
import java.util.Scanner;
public class Six4 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		long n = input.nextLong();
		System.out.print("the result is:"+reverse(n));
		input.close();
	  }
	public static long reverse(long n)
	  {
		long sum = 0,m = n;
		int x = 0; //用于记录位数
		while(n != 0)
		  {
			n = n / 10;
			x++;
		  }
		long a[] = new long[x];
		int y = 0;
		while(m != 0 && y < x)
		  {
			a[y] = m % 10;
			m = m /10;
			y++;
		  }
		for(int i = 0;i < x;i++)
		  {
			sum += a[i] * Math.pow(10, x-1-i);		
		  }
		return sum;
	  }
}

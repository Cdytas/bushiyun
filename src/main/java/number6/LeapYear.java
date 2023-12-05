package number6;
import java.util.Scanner;
public class LeapYear 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a year:");
		int n = input.nextInt();
		if(leapyear(n))
		  {
			System.out.print(n+"年是闰年");
		  }
		else
		  {
			System.out.print(n+"年不是闰年");
		  }
		input.close();
	  }
	public static boolean leapyear(int n)
	  {
		if(((n % 4 == 0) && (n % 100 != 0)) || (n % 400 == 0))
		  {
			return true;
		  }
		else
		  {
			return false;
		  }
	  }
}

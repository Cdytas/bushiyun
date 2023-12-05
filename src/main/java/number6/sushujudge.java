package number6;
import java.util.Scanner;
public class sushujudge 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		long n = input.nextLong();
        boolean t = sushu(n);
        if(t == true)
          {
        	System.out.print("该数是素数");
          }
        else
          {
      	    System.out.print("该数不是素数");
          }
        input.close();
	  }
	public static boolean sushu(long n)
	  {
		boolean sushu = true;
		if((n == 1) || (n <= 0))
		  {
			sushu = false;
		  }
		for(int i = 2;i <= Math.sqrt(n);i++)
		  {
			if(n % i == 0)
			  {
				sushu = false;
			  }
		  }
		return sushu;
	  }
}

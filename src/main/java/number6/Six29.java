package number6;
import java.util.Scanner;
public class Six29 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		long n = input.nextLong();
		long i = 2L;
		while(i < n)
		  {
			if(sushujudge.sushu(i) && sushujudge.sushu(i+2))
			  {
				System.out.printf("(%d,%d)\n",i,i+2);
			  }
			i++;
		  }
		input.close();
	  }
	
}

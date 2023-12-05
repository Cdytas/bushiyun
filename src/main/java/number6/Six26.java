package number6;
import java.util.Scanner;
public class Six26 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a intger:");
		long n = input.nextLong();
		int count = 0;
		long i = 2L;
		while(count < n)
		  {
			if(Six3.isPalindrome(i) && sushujudge.sushu(i))
			  {
				System.out.print(" "+i);
				count++;
				if(count % 10 == 0)
				  {
					System.out.println();
				  }
			  }
			i++;
		  }
		input.close();
	  }
}

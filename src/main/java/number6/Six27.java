package number6;
import java.util.Scanner;
public class Six27 
{
	public static void main(String[] args)
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		int n = input.nextInt();
		int count = 0;
		long i = 13L;
		while(count < n)
		  {
			if(sushujudge.sushu(i) && sushujudge.sushu(Six4.reverse(i)) && (i != Six4.reverse(i) ))
			  {
				System.out.print(" "+i);
				count++;
				if(count % 10 == 0)
				  {
					System.out.print('\n');
				  }
			  }
			i++;
		  }
		input.close();
	  }
}

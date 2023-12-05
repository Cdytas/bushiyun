package number6;
import java.util.Scanner;
public class Six28 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		int p = input.nextInt();
		int i = 1;
		System.out.println("p        2^p-1");
		System.out.println("____________________");
		while(i <= p)
		  {
			int n = (int) (Math.pow(2, i)-1);
			if(sushujudge.sushu(n))
			  {
				System.out.println(i+"        "+n);
			  }
			i++;
		  }
		input.close();
	  }
}

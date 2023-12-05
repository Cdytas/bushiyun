package number6;
import java.util.Scanner;
public class Six17 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
        int n = input.nextInt();
        printMatrix(n);
        input.close();
	  }
	public static void printMatrix(int n)
	  {
		for(int j = 0;j < n;j++) 
		  {
		    for(int i = 1;i < 2 * n;i++)
		      {
			    if(i % 2 == 1)
			      {
				    System.out.print((int)(Math.random() * 2));
			      }
			    else
			      {
				    System.out.print(" ");
			      }
			    if(i == 2 * n - 1)
			      {
				    System.out.println();
			      }
		      }
		  }
	  }
}

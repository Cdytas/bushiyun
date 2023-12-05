package number12;
import java.util.*;
public class number123 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		int []a = new int[100];
		for(int i = 0;i < 100;i++)
		  {
			a[i] = (int)(Math.random() * 100);
		  }
		System.out.print("please enter the index of the array:");
		try
		  {
			int index = input.nextInt();
			System.out.print(a[index]);
		  }
		catch(ArrayIndexOutOfBoundsException ex)
		  {
			System.out.print("Out of bounds");
		  }
		input.close();
	  }
}

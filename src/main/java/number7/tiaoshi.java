package number7;
import java.util.Scanner;
public class tiaoshi 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		int m[] = new int[10];
		for(int i = 0;i < m.length;i++)
		  {
			m[i] = input.nextInt();
		  }
		for(int i = 1;i < m.length;i++)
		  {
			m[i] = m[i-1];
		  }
		for(int i = 1;i < m.length;i++)
		  {
			System.out.print(" "+m[i]);
		  }
		input.close();
	  }
}

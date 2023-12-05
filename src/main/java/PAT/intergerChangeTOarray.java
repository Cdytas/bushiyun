package PAT;
import java.util.Scanner;
public class intergerChangeTOarray 
{
	public static void main(String[] args) 
      {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int a = weishu(n);
		int j = (int) Math.pow(10,a-1);
		int ab[] = new int[a];
		int i = 0;
		while(i < a)
		  {
			ab[i] = n / j;
			n = n - ab[i] * j;
			j = j / 10;
			i ++;
		  }
		System.out.println(a);
		for(int x:ab)
		  {
		    System.out.print(x);
		  }
		input.close();
      }
	public static int weishu(int n)
	  {
		int k = 0;
		while(n != 0)
		  {
			n = n / 10;
			k ++;
		  }
		return k;
	  }
}

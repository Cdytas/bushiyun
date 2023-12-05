package PAT;
import number6.sushujudge;
import java.util.Scanner;
public class pat1099 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一个整数：");
		int a = input.nextInt();
		if(sexsushu(a))
		  {
			System.out.println(a+"是性感素数");
			if(sushujudge.sushu(a - 6))
			  {
				System.out.println(a - 6);
			  }
			else
			  {
				System.out.println(a + 6);
			  }
		  }
		else
		  {
			System.out.println(a+"不是性感素数");
			int b = a + 1;
			while(!sexsushu(b))
			  {
				b ++;
			  }
			System.out.println(b);
		  }
		input.close();
	  }
	public static boolean sexsushu(int n)
	  {
		if(sushujudge.sushu(n) && (sushujudge.sushu(n - 6) || sushujudge.sushu(n + 6)))
		  {
			return true;
		  }
		else
		  {
			return false;
		  }
	  }
}

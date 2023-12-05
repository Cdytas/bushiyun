package Number10;
import java.math.BigInteger;
import java.util.Scanner;
public class Factorial 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		int n = input.nextInt();
		System.out.print(n+"! is \n"+factorial(n));
		input.close();
	  }
	public static BigInteger factorial(long n)
	  {
		BigInteger result = BigInteger.ONE;
		for(int i = 1;i <= n;i++)
		  {
			result = result.multiply(new BigInteger(i+""));/* mutiply方法的
			                                         参数要求是BigInteger类对象*/                                     
		  }
		return result;
	  }

}

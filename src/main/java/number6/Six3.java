package number6;
import java.util.Scanner;
public class Six3 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a integer:");
		long n = input.nextLong();
		if(isPalindrome(n) == true)
		  {
			System.out.print("您输入的数是回文数。");
		  }
		else
		  {
			System.out.print("您输入的数不是回文数。");
		  }	
		input.close();
	  }
	public static boolean isPalindrome(long n)
	  {
		if(Six4.reverse(n) == n)
	      return true;
		else
		  return false;
	  }
}

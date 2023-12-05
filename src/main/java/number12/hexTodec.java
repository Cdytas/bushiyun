package number12;
import java.util.Scanner;
public class hexTodec 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter a hex:");
		try
		  {
		    String hex = input.nextLine();
		    int dec = hextodecimal(hex);// 此处可能抛出异常
		    System.out.print("result is: "+dec);
		  }
		catch(number126 ex)
		  {
		  }
		input.close();
	  }
	public static int hexChartoDecimal(char c)
	  {
		if(c >= 'A' && c <= 'F')
		  {
			return c - 'A' + 10;
		  }
		if(c >= 'a' && c <= 'f')
		  {
			return c - 'a' + 10;
		  }
		else
		  return c - '0';
	  }
	public static int hextodecimal(String s) throws number126
	  {
		int sum = 0;
		if(!checkchar(s))
		  {
			throw new number126(s);
		  }
		else
		  {
			for(int i = 0;i < s.length();i++)
			  {
				char hexchar = s.charAt(i);
				sum = sum * 16 + hexChartoDecimal(hexchar);
			  }
			return sum;
		  } 
	  }
	public static boolean checkchar(String s)
	  {
		for(int i = 0;i < s.length();i++)
		  {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
			  continue;
			else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'F')
		      continue; 
			else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'f')
			  continue;
			else
			  return false;
		  }
		return true;
	  } 
}

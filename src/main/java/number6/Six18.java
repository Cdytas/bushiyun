package number6;
import java.util.Scanner;
public class Six18 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter your password:");
        String password = input.nextLine();
        PasswordJudge(password);
        input.close();
	  }
	public static void PasswordJudge(String password)
	  {
		int n = password.length();
        int numbers = 0,others = 0;
        for(int i = 0;i < n;i++)
          {
        	if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
        	  {
        		continue;
        	  }
        	else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
      	      {
      		    continue;
      	      }
        	else if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
        	  {
        		numbers++;
        	  }
        	else
        	  {
        		others++;
        	  }
          }
        if(others > 0 || numbers < 2 || n < 8)
          {
        	System.out.print("Invalid Password");
          }
        else
          {
        	System.out.print("Valid Password");
          }
	  }
}

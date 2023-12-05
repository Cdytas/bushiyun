package number12;
import java.util.*;
public class number122 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		int a,b;
		boolean continueinput = true;
		do
		  {
			try
			  {
				System.out.print("please enter two integers:");
				a = input.nextInt();
				b = input.nextInt();
				System.out.println("Input correct,result is:"+(a + b));
				continueinput = false;
			  }
			catch(InputMismatchException ex)
			  {
				System.out.println("Incorrect input,try again");
				input.nextLine(); //必须丢弃当前行，不然会陷入无限循环
			  }
		  }while(continueinput);
		input.close();
		}
}


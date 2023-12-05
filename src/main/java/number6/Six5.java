package number6;
import java.util.Scanner;
public class Six5 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter three digits:");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
        displaySortedNumbers(num1,num2,num3);
        input.close();
	  }
	public static void displaySortedNumbers(double num1,double num2,double num3)
	  {
		double max;
		if(num1 > num2)
		  {
			max = num1;
		  }
		else
		  {
			max = num2;
		  }
		if(max < num3)
		  {
			max = num3;
		  }
		System.out.print("the maximum of three digits is:"+max);
	  }
}

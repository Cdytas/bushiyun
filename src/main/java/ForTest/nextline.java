package ForTest;

import java.util.Scanner;
public class nextline
{
	public static void main(String[] args)
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("please enter inte1:");
		int inte1 = input.nextInt();  //基于标记的输入
		System.out.print("please enter str2:");
		String str2 = input.nextLine();   //基于行的输入
		System.out.println(inte1);
		System.out.println(str2);
		input.close();
	  }
}

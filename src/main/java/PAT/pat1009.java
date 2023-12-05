package PAT;
import java.util.Scanner;
public class pat1009 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();
		String str2 = "";
		String []str = new String[20];
		int i = 0;
		int j = 0;
		
		for(i = 0;i < str.length;i++)
		  {
			str[i] = "";
		  }
		while(str1.length() > 80)
		  {
			System.out.print("请重新输入一个字符串：");
			str1 = input.nextLine();
		  }
		for(i = 0;i < str1.length();i++)
		  {
			if(str1.charAt(i) != ' ')
			  {
				str[j] += str1.charAt(i);
			  }
			else
			  {
				j++;
			  }
		  }
		for(int k = j;k > 0;k--)
		  {
			str2 = str2 + str[k] + " ";
		  }
		str2 += str[0];
		System.out.print(str2);
		input.close();
	  }
}

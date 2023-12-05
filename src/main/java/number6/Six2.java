package number6;
import java.util.Scanner;
public class Six2 
{
	public static void main(String[] args) 
	  {
        Scanner input = new Scanner(System.in);
        System.out.print("please enter a integer:");
        long n = input.nextLong();
        System.out.println("各位数字的和为："+qiuhe(n));
        input.close();
	  }
	public static long qiuhe(long n)   //与c和c++不同。java中的方法即使定义在主方法下面，调用时也无需声明
	  {
		 long sum = 0;
	     long m;
	     while(n != 0)
	       {
	         m = n % 10;
	         sum += m;
	         n = n / 10;
	       }
		 return sum;
	  }
}

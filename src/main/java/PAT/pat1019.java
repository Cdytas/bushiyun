package PAT;
import java.util.Scanner;
public class pat1019 
{
	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一个四位整数：");
		int n = input.nextInt();
		int a[] = new int[4];
		int b[] = new int[4];
		while(n < 0 || n > 9999)
		  {
			System.out.print("输入错误，请重新输入：");
			n = input.nextInt();
		  }
		while(n != 6174)
		  {
			a = jiangxu(n);
			b = shengxu(n);
			for(int x:a)
			  {
		        System.out.print(x);
			  }
			System.out.print(" - ");
			for(int x:b)
			  {
				System.out.print(x);
			  }
			n = ArrayTointeger(a) - ArrayTointeger(b);
			System.out.println(" = "+n);
		  }
		input.close();
	  }
	public static int[] jiangxu(int n)
	  {
		int i = 0,k = 0;
		int m = n;    //保存n的值，避免在下面的求位数循环中丢失。导致数组填充失败
		while(n != 0)
		  {
			n = n / 10;
			k ++;
		  }
		int j = (int) Math.pow(10,k-1);
		int a[] = new int[k];
		while(i < k)
		  {
			a[i] = m / j;
			m = m - a[i] * j;
			j = j / 10;
			i ++;
		  }
		for(i = k-1;i > 0;i--)
		  {
			for(j = 0;j < i;j++)
			  {
				if(a[j] < a[j+1])
				  {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				  }	
			  }
		  }
		return a;
	  }
	public static int[] shengxu(int n)
	  {
		int i = 0,k = 0;
		int m = n;    //保存n的值，避免在下面的求位数循环中丢失。导致数组填充失败
		while(n != 0)
		  {
			n = n / 10;
			k ++;
		  }
		int j = (int) Math.pow(10,k-1);
		int a[] = new int[k];
		while(i < k)
		  {
			a[i] = m / j;
			m = m - a[i] * j;
			j = j / 10;
			i ++;
		  }
		for(i = k-1;i > 0;i--)
		  {
			for(j = 0;j < i;j++)
			  {
				if(a[j] > a[j+1])
				  {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				  }	
			  }
		  }
		return a;
	  }
	public static int ArrayTointeger(int a[])
	  {
		int i = 0,sum = 0;
		int k = a.length;
		int j = (int) Math.pow(10, k-1);
		while(i < k)
		  {
			sum = sum + a[i] * j;
			j = j / 10;
			i ++;
		  }
		return sum;
	  }
}

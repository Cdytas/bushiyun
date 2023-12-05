package number9;

public class Test9103 
{
	public static void main(String[] args) 
	  {
		int []a = {1,2};
		swap1(a[0],a[1]);
		System.out.print("a[0] = "+a[0]+","+"a[1] = "+a[1]);
		System.out.println('\n');
		swap2(a);
		System.out.print("a[0] = "+a[0]+","+"a[1] = "+a[1]);
	  }
	public static void swap1(int n,int m)
	  {
		int temp = n;
		n = m;
		m = temp;
	  }
	public static void swap2(int []a)
	  {
		int temp = a[0];
		a[0] = a[1];
		a[1] = temp;
	  }
}

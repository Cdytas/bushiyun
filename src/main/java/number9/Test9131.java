package number9;
public class Test9131 {
	private int i = 1;
	private static int j = 0;  //静态变量和局部变量的符号长相都不一样，很明了
	public static void main(String[] args) 
	  {
		Test9131 test = new Test9131();
		int i = 2;
		int k = 3;
		{
		  int j = 3;
		  System.out.println(i+j);
		}
		k = i + j;
		System.out.println(k);
		System.out.println(j);
		int l = test.sss(i,j);
		System.out.println(l);
	  }
	Test9131()
    {
		
	}
	public int sss(int i,int j)
	  {
		int k = 0;
		k = i + j + this.i;  //加上this，表示此处的i是类变量,释放被隐藏的类变量
		return k;
	  }
}

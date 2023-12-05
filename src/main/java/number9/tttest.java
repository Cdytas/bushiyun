package number9;
public class tttest   //关于传递基本类型值和引用值的测试
{
	public static void main(String[] args)
	  {
		Count mycount = new Count();
		int times = 0;
		for(int i = 0;i < 100;i++)
		  {
			increment(mycount,times);
		  }
		System.out.println("count is " + mycount.count);
		System.out.println("times are " + times);
	  }
	public static void increment(Count c,int n)
	  {
		c.count++;
		n++;
	  }
}

class Count
{
	public int count;
	public Count()
	  {
		count = 1;
	  }
}
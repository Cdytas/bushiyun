package number12;
public class Number12test6 
{
	public static void main(String[] args) throws ArithmeticException
	  {
		m();
		System.out.println(7);
	  }
	public static void m()
	  {
		try
		  {
			String a = null;
			System.out.println(1);
			System.out.println(1 / 0);
			System.out.println(3);
		  }
		catch(NullPointerException ex)
		  {
			System.out.println(4);
		  }
		finally
		  {
			System.out.println(5);
		  }
		System.out.println(6);
	  }

}

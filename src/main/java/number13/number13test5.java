package number13;

public class number13test5 implements Cloneable
{
    private int id;
    private String name;
	public number13test5()
	  {
		this(7,"Xiaozibei");
	  }
	public number13test5(int id,String name)
	  {
		this.id = id;
		this.name = name;
	  }
	@Override
	public Object clone()
	  {
		try
		  {
			return super.clone();
		  }
		catch(CloneNotSupportedException ex)
		  {
			return null;
		  }
	  } 
	@Override
	public String toString()
	  {
		return "id is " + id + ",name is "+name;
	  }
	public static void main(String[] args) 
	  {
		number13test5 s1 = new number13test5();
		number13test5 s2 = (number13test5)s1.clone();
		System.out.print(s2.toString());
	  }
}

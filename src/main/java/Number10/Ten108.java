package Number10;
public class Ten108 
{
    private String text;
    public Ten108(String s)
      {
    	text = s;
      }
	public static void main(String[] args) 
	  {
		Ten108 test = new Ten108("ABC");
		StringBuilder s1 = new StringBuilder("java");
		System.out.println(test.text);
		System.out.println(s1.insert(2,"is fun"));
		System.out.print(s1.replace(0, 3, "html"));
	  }
}

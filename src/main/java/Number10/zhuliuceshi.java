package Number10;
public class zhuliuceshi 
{
	public static void main(String[] args) 
	  {
		String s1 = "welcome to java";
		String s2 = s1;
		String s3 = new String("welcome to java");
		String s4 = "welcome to java";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1.equals(s3));
	  }

}

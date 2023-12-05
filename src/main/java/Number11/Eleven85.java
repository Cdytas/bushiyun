package Number11;

public class Eleven85 
{
	public static void main(String[] args) 
	  {
		new Person().printPerson();
		new Student().printPerson();
		new Student().printss(new Student().x);
	  }
}
	class Student extends Person
	  {
		public String x = "dwadwad";
		private String getInfo()
		  {
			return "Student";
		  }
	  }
	class Person
	  {
		private String getInfo()
		  {
			return "Person";
		  }
	    public void printPerson()
	      {
	    	System.out.println(getInfo());
	      }
	    public void printss(String s)
	      {
	    	System.out.print(s);
	      }
	  }

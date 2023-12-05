package number6;
public class Six33 
{
	public static void main(String[] args) 
	  {
		long totalseconds = System.currentTimeMillis() / 1000;
		long totalminutes = totalseconds / 60;
		long totalhours = totalminutes / 60;
		long totaldays = totalhours / 24;
		int n = 1970;
		while(n < 2022)
		  {
			if(LeapYear.leapyear(n))
			  {
				totaldays -= 366;
			  }
			else
			  {
				totaldays -= 365;
			  }	
			n++;
		  }
		System.out.print(totaldays);
	  }
}

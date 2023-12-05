package Number11;
public class Eleven87 
{
	public static void main(String[] args) 
	  {
		new C();
		new D();
	  }
}
    class C 
      {
    	int i = 7;
    	public C()
    	  {
    		setI(20);
    		System.out.println("i from C is "+i);
    	  }
    	public void setI(int i)
    	  {
    		this.i = i * 2;
    	  }
      }
    class D extends C
      {
  	    public D()
  	      {
  		    System.out.println("i from D is "+i);
  	      }
  	    public void setI(int i)
  	      {
  		    this.i = i * 3;
  	      }
      }


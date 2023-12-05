package Number10;
public class Ten4 
{
	private double x;
	private double y;
	public Ten4()
	  {
		this(0,0);
	  }
	public Ten4(double x,double y)
	  {
		this.x = x;
		this.y = y;
	  }
	public double distance(Ten4 mypoint)
	  {
		double n = Math.sqrt(Math.pow(this.x - mypoint.x,2)+Math.pow(this.y - mypoint.y,2));
		return n;
	  }
	public double distance(double x,double y)
	  {
		double n = Math.sqrt(Math.pow(this.x - x,2)+Math.pow(this.y - y,2));
		return n;
	  }
	public static double distance(Ten4 mypoint1,Ten4 mypoint2)
	  {
		double n = Math.sqrt(Math.pow(mypoint1.x - mypoint2.x,2)+Math.pow(mypoint1.y - mypoint2.y,2));
		return n;
	  }
	public double getX()
	  {
		return x;
	  }
	public double getY()
	  {
		return y;
	  }
	public void setX(double x)
	  {
		this.x = x;
	  }
	public void setY(double y)
	  {
		this.y = y;
	  }
	public static void main(String[] args) 
	  {
		Ten4 mypoint1 = new Ten4();
		Ten4 mypoint2 = new Ten4(10,30.5);
		double distance1 = distance(mypoint1,mypoint2);
		double distance2 = mypoint1.distance(mypoint2);
		double distance3 = mypoint1.distance(30,40);
		System.out.println(distance1);
		System.out.println(distance2);
		System.out.println(distance3);
	  }
}

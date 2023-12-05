package Number10;

public class Ten12 
{
	private Ten4 p1;
	private Ten4 p2;
	private Ten4 p3;
	
	public Ten12()
	  {
		this(new Ten4(0,0),new Ten4(1,1),new Ten4(2,5));
	  }
	
	public Ten12(Ten4 p1,Ten4 p2,Ten4 p3)
	  {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	  }
	
	public static double length(Ten4 p1,Ten4 p2)
	  {
		double c1 = Math.pow(p1.getX() - p2.getX(),2);
		double c2 = Math.pow(p1.getY() - p2.getY(),2);
	    return Math.sqrt(c1+c2);
	  }
	
	public double getPerimeter()
	  {
		double s1 = length(p1,p2);
		double s2 = length(p1,p3);
		double s3 = length(p2,p3);
		double s = s1 + s2 + s3;
		return s;
	  }
	
	public double getArea()
	  {
		double s;
		double s1 = length(p1,p2);
		double s2 = length(p1,p3);
		double s3 = length(p2,p3);
		s = (s1 + s2 + s3) / 2;
		return Math.sqrt(s*(s - s1) * (s - s2) * (s - s3));
	  }
	
	public boolean contains(Ten4 p)
	  {
		Ten12 s1 = new Ten12(p1,p2,p);
		Ten12 s2 = new Ten12(p1,p3,p);
		Ten12 s3 = new Ten12(p2,p3,p);
		if(s1.getArea() + s2.getArea() + s3.getArea() == this.getArea())
		  {
			return true;
		  }
		else
		  {
			return false;
		  }
	  }
	
	public boolean contains(Ten12 t)
	  {
		double area1 = this.getArea();
		double area2 = t.getArea();
		if(area1 > area2)
		  {
			if(this.contains(t.p1) && this.contains(t.p2) && this.contains(t.p3))
			  return true;
			else
			  return false;
		  }
		else
		  {
			if(t.contains(p1) && t.contains(p2) && t.contains(p3))
			  return true;
			else
			  return false;
		  }
	  }

	public static void main(String[] args) 
	  {
		Ten12 t1 = new Ten12(new Ten4(2.5,2),new Ten4(4.2,3),new Ten4(5,3.5));
		Ten12 t2 = new Ten12(new Ten4(2.9,2),new Ten4(4,1),new Ten4(1,3.4));
		System.out.println(t1.getPerimeter());
		System.out.println(t1.getArea());
		System.out.println(t1.contains(new Ten4(3,3) ));

	  }

}

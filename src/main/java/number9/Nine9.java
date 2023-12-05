package number9;
public class Nine9 
{
	public static void main(String[] args) 
	  {
		RegularPolygon polygon1 = new RegularPolygon();
		RegularPolygon polygon2 = new RegularPolygon(6,4);
		RegularPolygon polygon3 = new RegularPolygon(10,4,5.6,7.8);
		System.out.println(polygon1.getPerimeter());
		System.out.println(polygon2.getPerimeter());
		System.out.println(polygon3.getPerimeter());
		System.out.println(polygon1.getArea());
		System.out.println(polygon2.getArea());
		System.out.println(polygon3.getArea());
		polygon1.setN(5);
		polygon1.setSide(6);
		System.out.println(polygon1.getPerimeter());
		System.out.println(polygon1.getArea());
	  }
}

class RegularPolygon
{
	private int n = 3;
	private double side = 1;
	private double x = 0;
	private double y = 0;
	
	public RegularPolygon()
	{}
	public RegularPolygon(int n,double m)
	  {
		this.n = n;
		side = m;
	  }
	public RegularPolygon(int n,double m,double x,double y)
	  {
		this.n = n;
		side = m;
		this.x = x;
		this.y = y;
	  }
	
	public int getN()
	  {
		return n;
	  }
	public double getSide()
	  {
		return side;
	  }
	public double getX()
	  {
		return x;
	  }
	public double getY()
	  {
		return y;
	  }
	
	public void setN(int n)
	  {
		this.n = n;
	  }
	public void setSide(double n)
	  {
		side = n;
	  }
	public void setX(double n)
	  {
		x = n;
	  }
	public void setY(double n)
	  {
		y = n;
	  }
	public double getPerimeter()
	  {
		return n * side;
	  }
	public double getArea()
	  {
		return n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n));
	  }
}


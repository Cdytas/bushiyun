package number13;
import java.util.*;
public class Complex implements Cloneable,Comparable<Complex>
{
	private double a;
	private double b;
	public Complex()
	  {
	    this(0,0);
	  }
	public Complex(double a)
	  {
		this.a = a;
		this.b = 0;
	  }
	public Complex(double a,double b)
	  {
		this.a = a;
		this.b = b;
	  }
	public double getRealPart()
	  {
		return a;
	  }
	public double getImaginaryPart()
	  {
		return b;
	  }
	public double abs()
	  {
		return Math.sqrt(Math.pow(a,2) + Math.pow(b, 2));
	  }
	public Complex add(Complex c1)
	  {
		Complex c2 = new Complex();
		c2.a = this.a + c1.a;
		c2.b = this.b + c1.b;
		return c2;
	  }
	public Complex subtract(Complex c1)
	  {
		Complex c2 = new Complex();
		c2.a = this.a - c1.a;
		c2.b = this.b - c1.b;
		return c2;
	  }
	public Complex multiply(Complex c1)
	  {
		Complex c2 = new Complex();
		c2.a = this.a * c1.a - this.b * c1.b;
		c2.b = this.b * c1.a + this.a * c1.b;
		return c2;
	  }
	public Complex divide(Complex c1)
	  {
		Complex c2 = new Complex();
		c2.a = (this.a * c1.a + this.b * c1.b) / (Math.pow(c1.a, 2) + Math.pow(c1.b, 2));
		c2.b = (this.b * c1.a - this.a * c1.b) / (Math.pow(c1.a, 2) + Math.pow(c1.b, 2));
		return c2;
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
	public int compareTo(Complex c)
	  {
		if(this.abs() > c.abs())
		  return 1;
		else if(this.abs() < c.abs())
		  return -1;
		else
		  return 0;
	  }
	@Override
	public String toString()
	  {
		if(b == 0)
		  return a+"";
		else
	      return a+"+"+b+"i";
	  }

	public static void main(String[] args) 
	  {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter tht first complex number:");
		double a1 = input.nextDouble();
		double b1 = input.nextDouble();
		System.out.print("Enter tht second complex number:");
		double a2 = input.nextDouble();
		double b2 = input.nextDouble();
		Complex c1 = new Complex(a1,b1);
		Complex c2 = new Complex(a2,b2);
		Complex c3 = (Complex)c1.clone();
		System.out.println("("+a1+" + "+b1+"i)"+" + "+"("+a2+" + "+b2+"i)"+" = "+c1.add(c2).a+" + "+c1.add(c2).b+"i");
		System.out.println("("+a1+" + "+b1+"i)"+" - "+"("+a2+" + "+b2+"i)"+" = "+c1.subtract(c2).a+" + "+c1.subtract(c2).b+"i");
		System.out.println("("+a1+" + "+b1+"i)"+" * "+"("+a2+" + "+b2+"i)"+" = "+c1.multiply(c2).a+" + "+c1.multiply(c2).b+"i");
		System.out.println("("+a1+" + "+b1+"i)"+" / "+"("+a2+" + "+b2+"i)"+" = "+c1.divide(c2).a+" + "+c1.divide(c2).b+"i");
		System.out.println("|("+a1+" + "+b1+"i)|"+" = "+c1.abs());
		System.out.println(c1.compareTo(c2));
		System.out.println(c1.getRealPart());
		System.out.println(c1.getImaginaryPart());
		System.out.println("c3 is "+c3.toString());
		input.close();
	  }

}

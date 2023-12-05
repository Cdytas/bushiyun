package number9;

public class Test9102 
{
	public static void main(String[] args) 
	  {
		Circle circle1 = new Circle(1);
		Circle circle2 = new Circle(2);
		Circle circle3 = new Circle(3);
		System.out.println("circle3 = "+circle3.radius);
		circle3 = circle2;
		System.out.println("after,circle3 = "+circle3.radius); //对象可以直接赋值
		swap1(circle1,circle2);
		System.out.println("after swap1,circle1 = "+circle1.radius);
		System.out.println("after swap1,circle2 = "+circle2.radius);
		System.out.println();
		swap2(circle1,circle2);
		System.out.println("after swap2,circle1 = "+circle1.radius);
		System.out.println("after swap2,circle2 = "+circle2.radius);
	  }

public static void swap1(Circle x,Circle y)
{
  Circle temp = x;
  x = y;
  y = temp;
}

public static void swap2(Circle x,Circle y)
{
  double temp = x.radius;
  x.radius = y.radius;
  y.radius = temp;
}
}

class Circle
{
	double radius;
	Circle(double newRadius)
	  {
		radius = newRadius;
	  }
}

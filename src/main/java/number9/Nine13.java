package number9;
import java.util.Scanner;
public class Nine13 
{
	public static void main(String[] args) 
	  {
		int row = 0,column = 0;
		Scanner input = new Scanner(System.in);
		Location largest = new Location();
		System.out.print("Enter the number of rows and columns in the array:");
		row = input.nextInt();
		column = input.nextInt();
		double a[][] = new double[row][column];
		System.out.println("Enter the array:");
		for(int i = 0;i < row;i++)
		  {
			for(int j = 0;j < column;j++)
			  {
				a[i][j] = input.nextDouble();
			  }
		  }
		largest = locateLargest(a);
		System.out.println("The location of the largest element is:");
		System.out.println(largest.maxValue+" at "+"("+largest.row+","+
		largest.column+")");
		input.close();
	  }
	public static Location locateLargest(double [][]a)
	  {
		Location largest = new Location();
		int i = 0,j = 0;
		int row = a.length;
		int column = a[0].length;
		for(i = 0;i < row;i++)
		  {
			for(j = 0;j < column;j++)
			  {
				if(a[i][j] > largest.maxValue)
				  {
					largest.row = i;
					largest.column = j;
					largest.maxValue = a[i][j];
				  }
			  }
		  }
		return largest;
	  }
}

class Location
{
	public int row = 0;
	public int column = 0;
	public double maxValue = 0;
	public Location()
	{}
}
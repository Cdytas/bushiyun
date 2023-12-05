package number13;

public class number13test4 {

	public static void main(String[] args) 
	  {
		int []a = {1,3,5,7,9};
		int []b = a;  // b和a指向同一个对象
		int []c = a.clone(); //c指向新对象
		a[0] = 2;
		for(int x: b)
		  {
			System.out.print(x+" ");
		  }
		System.out.println();
		for(int x: c)
		  {
			System.out.print(x+" ");
		  }
	  }
}

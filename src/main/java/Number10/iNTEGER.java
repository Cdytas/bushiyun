package Number10;
public class iNTEGER {
	public static void main(String[] args) 
	  {
		int i = (Integer.valueOf("23")).intValue();
		int j = (Double.valueOf("23.4")).intValue();
		int h = (Integer.valueOf("23"));  //×Ô¶¯²ðÏä
		double k = (Double.valueOf("23.4"));
		int z = Integer.valueOf(5) + Integer.valueOf(10);
		Integer x = 35 + Integer.valueOf(5);
		Double y = 4.0;
		System.out.println(i+"   "+j);
		System.out.println(h+"   "+k+"   "+z);
		System.out.println(x.doubleValue());
		System.out.println(x.toString());
		System.out.println(Integer.parseInt("11",16));
		System.out.println(y.toString());
	  }

}

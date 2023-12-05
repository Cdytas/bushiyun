package Leetcode;
import java.util.Scanner;
public class leetcode7 {
	public static void main(String[] args) {
		int x = 0;
		System.out.print(reverse(x));
	}
	public static int reverse(int x) {
		if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE  || x == 0)
			return 0;
		boolean flag = true;
		if(x < 0)
			flag = false;
		int absx = Math.abs(x);
		String s1 = Intreverse(absx);
		String max = Integer.MAX_VALUE + "";
		String min = Integer.MIN_VALUE + "";
		if(flag == true){
			if(s1.length() >= 10 && s1.compareTo(max) > 0)
				return 0;
			else
				return Integer.parseInt(s1);
		}
		if(flag == false){
			if(s1.length() >= 10 && s1.compareTo(min.substring(1,11)) > 0)
				return 0;
			else
				return -Integer.parseInt(s1);
		}
		return 0;
	}
	public static String Intreverse(int n){
		if(n == 0){
			return "";
		}
		else{
			return "" + (n % 10) + Intreverse(n / 10);
		}
	}
}


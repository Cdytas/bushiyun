package Leetcode;
import java.util.*;
import java.math.*;


public class leetcode6338 {
        public int monkeyMove(int n) {
            BigInteger a = new BigInteger("1");
            BigInteger b = new BigInteger("2");
            while(n > 0){
                a = a.multiply(b);
                n--;
            }
            BigInteger res = ((a.subtract(b))).divideAndRemainder (new BigInteger("1000000007"))[1];
            String str = res.toString();
            int sum = 0;
            for(int i = 0;i < str.length();i++){
                sum = sum * 10 + (str.charAt(i) - '0');
            }
            return sum;
        }
}

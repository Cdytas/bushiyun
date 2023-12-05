package Leetcode;
import java.util.*;
public class leetcode970 {

    public static void main(String[] args) {
        List<Integer> res = powerfulIntegers(2,3,10);

    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> memo = new HashMap<>();
        if (x == 1 && y == 1) {
            if (bound >= 2) {
                res.add(2);
            }
            return res;
        }
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        int count1 = 0;
        int count2 = 0;
        int sup1 = x;
        int sup2 = y;
        while (sup1 <= bound) {
            count1++;
            sup1 *= x;
        }
        if (y == 1) {
            sup1 = 1;
            for (int i = 0; i <= count1; i++) {
                if (sup1 + 1 <= bound) {
                    res.add(sup1 + 1);
                    sup1 *= x;
                }
                else {
                    break;
                }
            }
            return res;
        }
        while (sup2 <= bound) {
            count2++;
            sup2 *= y;
        }
        sup1 = 1;
        sup2 = 1;
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            if (sup1 > bound) {
                break;
            }
            sup2 = 1;
            for (int j = 1; j <= count2; j++) {
                sum = sup1 + sup2;
                if (sum <= bound && !memo.containsKey(sum)) {
                    memo.put(sum, 1);
                    res.add(sum);
                }
                else if (sum > bound){
                    break;
                }
                sup2 *= y;
            }
            sup1 *= x;
        }
        return res;
    }



}

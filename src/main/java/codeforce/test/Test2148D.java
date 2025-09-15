package codeforce.test;

import java.util.*;

public class Test2148D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            List<Integer> list = new ArrayList<>();
            long sum = 0;
            for (int j = 0; j < n; j++) {
                int num = input.nextInt();
                if (num % 2 == 0) {
                    sum += num;
                } else {
                    list.add(num);
                }
            }
            if (list.size() == 0){
                System.out.println(0);
                continue;
            }
            Collections.sort(list);
            int j = 0, k = list.size() - 1;
            while (j <= k) {
                sum += list.get(k);
                k--;
                j++;
            }
            System.out.println(sum);
        }
    }
}

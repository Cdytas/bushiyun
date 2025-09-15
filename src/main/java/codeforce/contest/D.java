package codeforce.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int y = input.nextInt();
            int max = 0;
            int[] arr = new int[n];
            Map<Integer, Integer> memo = new HashMap<>();
            for (int j = 0; j < n; j++) {
                arr[j] = input.nextInt();
                max = Math.max(max, arr[j]);
                int cnt = memo.getOrDefault(arr[j], 0) + 1;
                memo.put(arr[j], cnt);
            }
        }

    }
}

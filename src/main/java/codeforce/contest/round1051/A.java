package codeforce.contest.round1051;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for  (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = input.nextInt();
            }

            boolean flag = true;
            int j = 0;
            int k = n - 1;
            int start = 1;
            while (j < k) {
                if (arr[j] == start) {
                    j++;
                    start++;
                } else if (arr[k] == start) {
                    k--;
                    start++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

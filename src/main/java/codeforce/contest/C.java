package codeforce.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    static int MOD = 998244353;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            int[][] memo = new int[2][n];
            for (int j = 0; j < n; j++) {
                arr1[j] = input.nextInt();
            }
            for (int j = 0; j < n; j++) {
                arr2[j] = input.nextInt();
            }
            for (int j = 0; j < 2; j++) {
                Arrays.fill(memo[j], -1);
            }
            int res = f(0, 0, arr1, arr2, memo);
            System.out.println(res);
        }
    }

    public static int f(int preChange, int i, int[] a, int[] b, int[][] memo) {
        if (i == a.length) {
            return 1;
        }
        if (memo[preChange][i] != -1) {
            return memo[preChange][i];
        }
        int res = 0;
        if (i == 0) {
            res = (res + f(0, i + 1, a, b, memo)) % MOD;
            res = (res + f(1, i + 1, a, b, memo)) % MOD;
            return memo[preChange][i] = res;
        }
        if (preChange == 0) {
            if (a[i] >= a[i - 1] && b[i] >= b[i - 1]) { // 可以不交换
                res  = (res + f(0, i + 1, a, b, memo)) % MOD;
            }
            if (a[i] >= b[i - 1] && b[i] >= a[i - 1]) { // 交换
                res  = (res + f(1, i + 1, a, b, memo)) % MOD;
            }
        } else {
            if (a[i] >= b[i - 1] && b[i] >= a[i - 1]) {
                res  = (res + f(0, i + 1, a, b, memo)) % MOD;
            }
            if (a[i] >= a[i - 1] && b[i] >= b[i - 1]) {
                res  = (res + f(1, i + 1, a, b, memo)) % MOD;
            }
        }
        return  memo[preChange][i] = res;
    }
}

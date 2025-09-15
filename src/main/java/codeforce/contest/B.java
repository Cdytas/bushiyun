package codeforce.contest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] arr = new int[n];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                arr[j] = input.nextInt();
                if (arr[j] != 0) {
                    set.add(arr[j]);
                }
            }
            int cnt = n - set.size();
            int left = n;
            int right = -1;

            for (int j = 0; j < n; j++) {
                if (arr[j] == 0) {
                    if (cnt > 1 || set.contains(j + 1)) { // 可以错位填
                        left = j;
                        break;
                    }
                } else {
                    if (arr[j] != j + 1) {
                        left = j;
                        break;
                    }
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] == 0) {
                    if (cnt > 1 || set.contains(j + 1)) {
                        right = j;
                        break;
                    }
                } else {
                    if (arr[j] != j + 1) {
                        right = j;
                        break;
                    }
                }
            }

            if (left >= right) {
                System.out.println(0);
            } else {
                System.out.println(right - left + 1);
            }
        }
    }
}

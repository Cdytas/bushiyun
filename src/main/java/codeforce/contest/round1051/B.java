package codeforce.contest.round1051;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for  (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] price = new int[n];
            int[] dis = new int[k];
            for (int j = 0; j < n; j++) {
                price[j] = input.nextInt();
            }
            for (int j = 0; j < k; j++) {
                dis[j] = input.nextInt();
            }

            Arrays.sort(price);
            Arrays.sort(dis);

            int idx = 0;
            int j = n - 1;
            long sum = 0;
            while (j >= 0) {
                int x = idx < k ? dis[idx++] : 0;
                if (x == 0) {
                    while (j >= 0) {
                        sum += price[j];
                        j--;
                    }
                    break;
                }

                if (x == 1) {
                    j--;
                } else {
                    if (j + 1 < x) { // 商品总数不够
                        while(j >= 0) {
                            sum += price[j];
                            j--;
                        }
                    } else {
                        int endIdx = j - x + 1;
                        while (j >= Math.max(0, endIdx + 1)) {
                            sum += price[j];
                            j--;
                        }
                        j--; // 跳过无需付费的
                    }
                }
            }
            System.out.println(sum);
        }
    }
}

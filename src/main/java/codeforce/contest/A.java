package codeforce.contest;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n =  input.nextInt();
            int[] preSum = new int[n + 1];
            for (int j = 0; j < n; j++) {
                int num =  input.nextInt();
                preSum[j + 1] = preSum[j] + num;
            }

            boolean flag = false;
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = preSum[j + 1] % 3;
                    int b = (preSum[k + 1] - preSum[j + 1]) % 3;
                    int c = (preSum[n] - preSum[k + 1]) % 3;
                    if (a != b && a != c && b != c) {
                        System.out.println((j + 1) + " " + (k + 1));
                        flag = true;
                        break;
                    }
                    if (a == b && b == c) {
                        System.out.println((j + 1) + " " + (k + 1));
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                System.out.println(0 + " " + 0);
            }
        }
    }
}

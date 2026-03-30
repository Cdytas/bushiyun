

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int k = 0; k < t; k++) {
            int n = Reader.nextInt();
            if (n % 2 == 0) {
                System.out.println(n / 2 - 1);
            } else {
                System.out.println(n / 2);
            }
        }
    }

    public static int f(int i, int startIndex, int[] arr, int[][] memo) {
        if (i == startIndex) {
            return 1;
        }
        if (memo[i][startIndex] != -1) {
            return memo[i][startIndex];
        }
        int res = 0;
        for (int j = i - 1; j >= startIndex; j--) {
            if (arr[i] > arr[j]) {
                res = Math.max(res, f(j, startIndex, arr, memo));
            }
        }
        return memo[i][startIndex] = res + 1;
    }


    static class Reader {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        // 读取下一行字符串
        static String nextLine() throws IOException {
            return br.readLine();
        }

        // 读取下一个字符串
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(br.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static BigInteger nextBingInteger() throws IOException {
            return new BigInteger(nextLine(), 10);
        }
    }
}



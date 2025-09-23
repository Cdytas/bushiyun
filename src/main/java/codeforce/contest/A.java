package codeforce.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = Reader.nextInt();
            int[] cnt = new int[n + 1];
            Map<Integer, Integer> memo = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int num = Reader.nextInt();
                cnt[num]++;
            }
            for (int x : cnt) {
                int val = memo.getOrDefault(x, 0) + 1;
                memo.put(x, val);
            }
            int res = 0;
            int sum = 0;
            for (int j = n; j >= 1; j--) {
                int val = memo.getOrDefault(j, 0);
                sum += val;
                res = Math.max(res, j * sum);
            }
            System.out.println(res);
        }
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



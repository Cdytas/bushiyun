package com.barca.bushiyun.codeforce.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class F {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int k = 0; k < t; k++) {
            int n = Reader.nextInt();
            int m = Reader.nextInt();

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

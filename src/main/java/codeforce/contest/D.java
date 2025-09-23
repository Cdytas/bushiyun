package codeforce.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int i = 0; i < t; i++) {
            int l =  Reader.nextInt();
            int r = Reader.nextInt();
            int len = 32 - Integer.numberOfLeadingZeros(r);
            int max = (1 << len) - 1;
            Set<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int j = l; j <= r; j++) {
                int origin = max - j;
                int sub = origin;
                while (sub > r || set.contains(sub)) {
                    sub = (sub - 1) & origin;
                }
                set.add(sub);
                sb.append(sub + " ");
            }
            System.out.println((long)(r + l) * (r - l + 1));
            System.out.println(sb);
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

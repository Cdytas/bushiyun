package codeforce.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = Reader.nextInt();
            int m = Reader.nextInt();
            int[] cnt = new int[m + 1];
            Map<Integer, Integer> memo = new HashMap<>();
            Set<Integer> set = new HashSet<>();

            for (int j = 1; j <= n; j++) {
                int l  = Reader.nextInt();
                for (int k = 0; k < l; k++) {
                    int x = Reader.nextInt();
                    cnt[x]++;
                    if (cnt[x] == 1) {
                        memo.put(x, j);
                    }
                }
            }

            boolean flag = true;
            for (int j = 1; j <= m; j++) {
                if (cnt[j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
                continue;
            }

            int necessary = 0;
            for (int x = 1; x <= m; x++) {
                if (cnt[x] == 1) {
                    int index = memo.get(x);
                    if (!set.contains(index)) {
                        necessary++;
                        set.add(index);
                    }
                }
            }

            if (necessary < n - 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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

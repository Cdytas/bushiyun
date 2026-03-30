

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
            int k = Reader.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Reader.nextInt();
            }

            int[] diff = new int[n + 1];  // 拆分贡献
            int[] cnt = new int[n + 1];  // 不拆分的贡献
            for (int x : arr) {
                cnt[x]++;

                int d = x / 4;
                diff[1]++;
                diff[d + 1]--;

                for (int j = 2; j <= Math.sqrt(x); j++) {
                    if (x % j != 0) {
                        continue;
                    }

                    if (j > d) {
                        cnt[j]++;
                    }
                    if (x / j > d && x / j != j) {
                        cnt[x / j]++;
                    }
                }

            }

            int res = 1;
            for (int d = 2; d <= n; d++) {
                diff[d] += diff[d - 1];
                if (diff[d] + cnt[d] >= n - k) {
                    res = Math.max(res, d);
                }
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





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int k = 0; k < t; k++) {
            int n = Reader.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Reader.nextInt();
            }

            boolean[] confirmed = new boolean[n + 1];
            int[] idx = new int[n + 1];
            for (int i = 0; i < n; i++) {
                idx[arr[i]] = i;
            }

            for (int i = 0; i < n; i++) {
                int x = arr[i];

                while (x >= 3 && !confirmed[x - 1] && !confirmed[x - 2]) {
                    int idxj = idx[x - 1];
                    int idxk = idx[x - 2];

                    arr[idxj] = x;
                    arr[idxk] = x - 1;
                    arr[i] = x - 2;

                    idx[x - 1] = idxk;
                    idx[x - 2] = i;
                    idx[x] = idxj;

                    x -= 2;
                }
                confirmed[x] = true;
            }

            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
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

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static BigInteger nextBingInteger() throws IOException {
            return new BigInteger(nextLine(), 10);
        }
    }
}

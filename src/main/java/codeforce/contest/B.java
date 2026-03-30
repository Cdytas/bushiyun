

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {
        int t = Reader.nextInt();
        for (int k = 0; k < t; k++) {
            int n = Reader.nextInt();
            int q =  Reader.nextInt();
            char[] s = Reader.nextLine().toCharArray();
            boolean haveB = false;
            for (char c : s) {
                if (c == 'B') {
                    haveB = true;
                    break;
                }
            }

            for (int i = 0; i < q; i++) {
                int a = Reader.nextInt();
                if (!haveB) {
                    System.out.println(a);
                    continue;
                }

                int j = 0;
                int second = 0;
                while (a > 0) {  // O(nloga)
                    if (s[j] == 'A') {
                        a--;
                    } else {
                        a /= 2;
                    }
                    second++;
                    j = (j + 1) % n;
                }
                System.out.println(second);
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

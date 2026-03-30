package codeforce.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        int ac = Reader.nextInt();
        int dr =  Reader.nextInt();
        int n = Reader.nextInt();
        int[][] pre = new int[n][2];
        for (int i = 0; i < n; i++) {
            pre[i][0] = Reader.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pre[i][1] = Reader.nextInt();
        }
        int m = Reader.nextInt();
        int[][] req =  new int[m][3];
        for (int i = 0; i < m; i++) {
            req[i][0] = Reader.nextInt() - 1;
            req[i][1] = Reader.nextInt();
            req[i][2] = Reader.nextInt();
        }

        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int need = Math.max(pre[i][0] - ac, 0) + Math.max(pre[i][1] - dr, 0);
            if (need < n) {  // 需求太高的人没必要考虑
                cnt[need]++;
            }
        }

        for (int i = 0; i < m; i++) {
            int user = req[i][0];
            int originalNeed = Math.max(pre[user][0] - ac, 0) + Math.max(pre[user][1] - dr, 0);
            int newNeed = Math.max(req[i][1] - ac, 0) + Math.max(req[i][2] - dr, 0);
            if (originalNeed < n) {
                cnt[originalNeed]--;
            }
            if (newNeed < n) {
                cnt[newNeed]++;
            }
            pre[user][0] = req[i][1];
            pre[user][1] = req[i][2];
            int p = check(cnt);
            System.out.println(p);
        }
    }

    public static int check(int[] cnt) {
        int p = cnt[0];
        for (int i = 1; i < cnt.length; i++) {
            if (p >= i) {
                p += cnt[i];
            } else {
                break;
            }
        }
        return p;
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

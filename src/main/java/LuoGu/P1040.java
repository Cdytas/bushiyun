package LuoGu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1040 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] arr = new long[n + 1];
        Map<Integer, Node> memo = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = input.nextLong();
        }
        Node res = f(1, n, arr, memo);
        System.out.println(res.score);
        String s = res.s;
        System.out.print(s.substring(0, s.length() - 1));
    }

    private static Node f(int left, int right, long[] arr, Map<Integer, Node> memo) {
        if (left > right) {
            return new Node(1L, "");
        }
        if (left == right) {
            return new Node(arr[left], ""+ left + " ");
        }
        int n = arr.length;
        int sign = left * (n + 1) + right;
        if (memo.containsKey(sign)) {
            return memo.get(sign);
        }
        Node res = new Node(0L, "");
        for (int i = left; i <= right; i++) {
            Node l = f(left, i - 1, arr, memo);
            Node r = f(i + 1, right, arr, memo);
            long score = l.score * r.score + arr[i];
            if (score > res.score) {
                res.score = score;
                res.s = i + " "  + l.s + r.s;
            }
        }
        memo.put(sign, res);
        return res;
    }

    private static class Node {
        long score = 0;
        String s = "";

        public Node(long score, String s) {
            this.score = score;
            this.s = s;
        }
    }
}

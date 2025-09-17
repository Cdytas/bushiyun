package codeforce.contest.round1051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for  (int i = 0; i < t; i++) {
            int n = input.nextInt();
            List<Integer>[] adj = new ArrayList[n];
            Arrays.setAll(adj, e -> new ArrayList<>());
            for(int j = 0; j < n; j++) {
                int u = input.nextInt();
                int v = input.nextInt();
                int x = input.nextInt();
                int y = input.nextInt();
                adj[u].add(v);
            }
        }
    }
}

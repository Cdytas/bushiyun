package codeforce.contest.round989;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int m = input.nextInt();
            int n = input.nextInt();
            char[][] grid = new char[m][];
            for (int j = 0; j < m; j++) {
                input.nextLine();
                grid[j] = input.next().toCharArray();
            }
        }
    }
}

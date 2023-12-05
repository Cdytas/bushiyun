package Leetcode;
import java.util.*;
public class leetcode1042 {
    public static void main(String[] args) {
        int[][] paths = {};
        int n = 5;
        int[] res = gardenNoAdj(n, paths);
        for (int x : res) {
            System.out.print(x +" ");
        }
    }

    public static int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] use = new int[5];
        int[] res = new int[n];
        for (int i = 0; i < paths.length; i++) {
            List<Integer> list = map.getOrDefault(paths[i][0] - 1, new ArrayList<Integer>());
            list.add(paths[i][1] - 1);
            map.put(paths[i][0] - 1, list);
            list = map.getOrDefault(paths[i][1] - 1, new ArrayList<Integer>());
            list.add(paths[i][0] - 1);
            map.put(paths[i][1] - 1, list);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(i);
            if (list == null) {
                res[i] = 1;
                continue;
            }
            Arrays.fill(use, 0);
            for (int x : list) {
                use[res[x]]++;
            }
            for (int j = 1; j < 5; j++) {
                if (use[j] == 0) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}

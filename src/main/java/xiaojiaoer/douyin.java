package xiaojiaoer;

import java.util.ArrayList;
import java.util.List;

public class douyin {
    public static void main(String[] args) {
        boolean[] used = new boolean[10];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, used, 0);
        for (List<Integer> list : res) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(List<List<Integer>> res, List<Integer> path, boolean[] used, int index) {
        if (index == 9) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index == 0) {
            for (int i = 1; i <= 9; i++) {
                used[i] = true;
                path.add(i);
                dfs(res, path, used, 1);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
        else if (index == 1 || index == 8) {
            for (int i = 1; i <= 9; i++) {
                if (!used[i] && path.get(path.size() - 1) + i == 13) {
                    used[i] = true;
                    path.add(i);
                    dfs(res, path, used, index + 1);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
        else if (index == 2 || index == 4 || index == 6) {
            for (int i = 1; i <= 9; i++) {
                if (!used[i] && path.get(path.size() - 1) + i < 13) {
                    used[i] = true;
                    path.add(i);
                    dfs(res, path, used, index + 1);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
        else  {
            for (int i = 1; i <= 9; i++) {
                if (!used[i] && path.get(path.size() - 1) + path.get(path.size() - 2) +  i == 13) {
                    used[i] = true;
                    path.add(i);
                    dfs(res, path, used, index + 1);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

}

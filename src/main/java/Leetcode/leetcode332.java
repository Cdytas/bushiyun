package Leetcode;
import java.util.*;

public class leetcode332 {

    List<String> path = new ArrayList<>();  //结果路径
    Map<String, List<String>> map = new HashMap<>();  //存储每个机场和其能到达的地方
    Map<String, Integer> place = new HashMap<>();  //将每个机场映射为数字编号
    int countOftickets;  //机票总数
    boolean[][] used;  //用于存储某张机票是否使用过
    boolean find = false;  //用于判断是否已找到可行飞行路线
    public List<String> findItinerary(List<List<String>> tickets) {
        this.countOftickets = tickets.size();
        place.put("JFK", 0);
        int counofplaces = 1;
        for (List<String> list : tickets) {
            String key = list.get(0);
            String value = list.get(1);
            if (!place.containsKey(key)) {
                place.put(key, counofplaces++);
            }
            if (!place.containsKey(value)) {
                place.put(value, counofplaces++);
            }
            List<String> sup = map.getOrDefault(key, new ArrayList<String>());
            sup.add(value);
            map.put(key, sup);
        }
        this.used = new boolean[counofplaces][countOftickets];
        path.add("JFK");
        dfs(0, "JFK");
        return path;
    }

    public void dfs(int count, String now) {
        if (count == countOftickets) {  //所有机票都用完
            find = true;  //已找到飞行路径，可以返回输出了
            return;
        }
        List<String> list = map.get(now);  //当前机票能到达的地方
        if (list == null) {
            return;
        }
        int num = place.get(now);  //当前地方的编号
        Collections.sort(list);   //排序，每次选最字典序最小的地方飞
        for (int i = 0; i < list.size(); i++) {
            if (used[num][i]) {   //当前起飞点的第i张机票已使用
                continue;
            }
            path.add(list.get(i));
            used[num][i] = true;
            dfs(count + 1, list.get(i));
            if (find == true) {
                return;   //找到第一个结果即可一路返回，不用再回溯了
            }
            used[num][i] = false;
            path.remove(path.size() - 1);
        }
    }

}

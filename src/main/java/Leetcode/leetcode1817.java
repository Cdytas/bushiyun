package Leetcode;
import java.util.*;
public class leetcode1817 {
    public static void main(String[] args) {
        int[][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k = 5;
        int[] a = findingUsersActiveMinutes(logs,k);
        for(int x:a)
            System.out.println(x + " ");
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] a = new int[k];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            List<Integer> list = map.getOrDefault(logs[i][0],new ArrayList<Integer>());
            if(!list.contains(logs[i][1]))
                list.add(logs[i][1]);
            map.put(logs[i][0],list);
        }
        Collection<List<Integer>> collect = map.values();
        Iterator<List<Integer>> iterator = collect.iterator();
        while(iterator.hasNext()){
            a[iterator.next().size() - 1]++;
        }
        return a;
    }

}

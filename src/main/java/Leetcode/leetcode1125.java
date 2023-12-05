package Leetcode;
import java.util.*;

public class leetcode1125 {
    public static void main(String[] args) {
        String[] req_skills = {"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList("java"));
        people.add(Arrays.asList("nodejs"));
        people.add(Arrays.asList("nodejs","reactjs"));
        int[] res = smallestSufficientTeam(req_skills, people);
        for (int x : res) {
            System.out.println(x + " ");
        }
    }


    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> skill = new ArrayList<>();
        int signal = 0;
        int sumOfPeople = people.size();
        int count = sumOfPeople;
        int[] need = new int[sumOfPeople];
        int[][] len = new int[sumOfPeople][2];
        for (int i = 0; i < req_skills.length; i++) {
            String str = req_skills[i];
            map.put(str, signal++);   //将需要的技能转化为数字方便处理
        }
        int[] have = new int[signal];
        for (int i = 0; i < sumOfPeople; i++) {
            List<String> list = people.get(i);
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                String key = list.get(j);
                int value = map.get(key);
                have[value]++;
                list2.add(value);
            }
            len[i][0] = list.size();
            len[i][1] = i;
            skill.add(list2);
        }
        for (int i = sumOfPeople - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (len[j][0] > len[j + 1][0]) {
                    int temp = len[j][0];
                    len[j][0] = len[j + 1][0];
                    len[j + 1][0] = temp;
                    temp = len[j][1];
                    len[j][1] = len[j + 1][1];
                    len[j + 1][1] = temp;
                }
            }
        }
        for (int i = 0; i < sumOfPeople; i++) {
            int index = len[i][1];
            List<Integer> list = skill.get(index);
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if (have[list.get(j)] > 1) {
                    continue;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                for (int j = 0; j < list.size(); j++) {
                    have[list.get(j)]--;
                }
                need[index] = -1;
                count--;
            }
        }
        int[] res = new int[count];
        count = 0;
        for (int i = 0; i < sumOfPeople; i++) {
            if (need[i] == 0) {
                res[count++] = i;
            }
        }
        return res;
    }
}

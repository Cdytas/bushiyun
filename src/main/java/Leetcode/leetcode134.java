package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode134 {
    public static void main(String[] args) {
        int[] gas = {7,1,0,11,4};
        int[] cost = {5,9,1,2,5};
        System.out.print(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n == 1)
            return gas[0] >= cost[0] ? 0 : -1;
        List<Integer> list = new ArrayList<>();
        int gass = 0;
        int costs = 0;
        for(int i = 0;i < n;i++){
            if(gas[i] >= cost[i])
                list.add(i);
            gass += gas[i];
            costs += cost[i];
        }
        if(gass < costs)
            return -1;
        gass = 0;
        costs = 0;
        for(int i = 0;i < list.size();i++){
            int start = list.get(i);
            int index = start;
            gass += gas[index];
            costs += cost[index++];
            if(index == n)
                index = 0;
            while(index != start){
                if(gass < costs){
                    gass = 0;
                    costs = 0;
                    break;
                }
                gass += gas[index];
                costs += cost[index++];
                if(index == n)
                    index = 0;
                if(index == start)
                    return start;
            }
        }
        return -1;
    }
}

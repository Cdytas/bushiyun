package Leetcode;
import java.util.*;

public class leetcode1642 {
    public static void main(String[] args) {
        int[] heights = {7,5,13};
        System.out.println(furthestBuilding(heights, 0, 0));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int index = 0;
        int bricks2 = bricks;
        int ladders2  = ladders;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                index = i + 1;
                continue;
            }
            int sub = heights[i + 1] - heights[i];
            if (bricks2 >= sub) {
                list.add(sub);
                bricks2 -= sub;
                index = i + 1;
            }
            else {
                break;
            }
        }
        for (int i = index; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                index = i + 1;
                continue;
            }
            else if (ladders2 > 0) {
                ladders2--;
                list.add(heights[i + 1] - heights[i]);
                index = i + 1;
            }
            else {
                break;
            }
        }
        if (index == heights.length - 1 || index == 0) {
            return index;
        }
        Collections.sort(list);
        int n = list.get(list.size() - ladders);
        int i = 0;
        for (i = 0; i < index; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int sub = heights[i + 1] - heights[i];
            if (sub >= n) {
                ladders--;
            }
            else {
                bricks -= sub;
            }
        }
        for (i = index; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int sub = heights[i + 1] - heights[i];
            if (bricks >= sub) {
                bricks -= sub;
            }
            else {
                return i;
            }
        }
        return i;
    }
}

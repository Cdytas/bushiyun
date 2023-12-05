package Leetcode;

public class leetcode209 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen1(11,nums));
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int min = nums.length;
        int len = min;
        int[] before = new int[len + 1];
        before[0] = 0;
        for (int i = 1; i <= len; i++) {
            before[i] = before[i - 1] + nums[i - 1];
        }
        if (before[len] < target) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            int limit = Math.min(i + min, len);
            for (int j = i + 1; j <= limit; j++) {
                if (before[j] - before[i] >= target) {
                    min = Math.min(min, j - i);
                    if (min == 1) {
                        return 1;
                    }
                    limit = min;
                    break;
                }
            }
        }
        return min;
    }
}

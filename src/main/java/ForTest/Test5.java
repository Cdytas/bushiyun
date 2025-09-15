package ForTest;
import java.util.*;


public class Test5 {
    public static void main(String[] args) {
        int[] arrivals = {1,2,3,3,3,4};
        System.out.println(new Test5().minArrivalsToDiscard(arrivals, 3,2));
    }

    int MAX = (int)1e5;
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        int res = Integer.MAX_VALUE;

        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, arrivals, w, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int k, int[] arrivals, int w, int m) {
        int[] type = new int[MAX + 1];
        int n = arrivals.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int preDay = i - w;
            int t = arrivals[i];
            if (preDay >= 0) {
                type[arrivals[preDay]]--;
            }
            type[t]++;
            if (type[t] > m) {
                type[t]--;
                res++;
            }
        }
        return res <= k;
    }
}

package ForTest;

public class test9 {
    public static void main(String[] args) {
        int[] arrivals = {7,3,9,9,7,3,5,9,7,2,6,10,9,7,9,1,3,6,2,4,6,2,6,8,4,8,2,7,5,6};
        System.out.println(minArrivalsToDiscard(arrivals, 10, 1));
    }

    public static boolean check(int k, int[] arrivals, int w, int m) {
        int MAX = (int)1e5;
        int[] type = new int[MAX + 1];
        int n = arrivals.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int preDay = i - w + 1;
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

    public static int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int MAX = 10;
        int[] type = new int[MAX + 1];
        int n = arrivals.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int preDay = i - w;
            int t = arrivals[i];
            if (preDay >= 0) {
                type[arrivals[preDay]] = Math.max(0, type[arrivals[preDay]] - 1);
            }
            type[t]++;
            if (type[t] > m) {
                type[t]--;
                res++;
            }
        }
        return res;
    }
}

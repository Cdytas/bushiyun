package xiaojiaoer;

public class PAC {
    public static void main(String[] args) {
        System.out.println(PAC(1000,3));
    }

    public static long PAC(int sum, int num) {
        long sum1 = 1;
        long sum2 = 1;
        int j = 0;
        int cnt = 0;
        int sup = num;
        if (num > sum / 2) {
            sup = sum - num;
        }
        while (j < sup) {
            sum1 *= sum - j;
            while (sum1 % 2 == 0) {
                sum1 /= 2;
                cnt++;
            }
            j++;
        }
        while (sup > 1) {
            sum2 *= sup;
            while (sum2 % 2 == 0 && cnt > 0) {
                sum2 /= 2;
                cnt--;
            }
            sup--;
        }
        while (cnt > 0) {
            sum1 *= 2;
            cnt--;
        }
        return sum1 / sum2;
    }
}

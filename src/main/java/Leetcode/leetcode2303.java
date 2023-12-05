package Leetcode;

public class leetcode2303 {
    public static void main(String[] args) {
        int[][] nums = {{3,50},{7,10},{12,25}};
        int income = 10;
        System.out.println(calculateTax(nums,income));
    }

    public static double calculateTax(int[][] brackets, int income) {

        double sum = 0;
        int i = 1;
        int income2 = income;
        if(income >= brackets[0][0]){
            sum += (double)(brackets[0][0] * brackets[0][1]) / 100;
            income2 = income - brackets[0][0];
        }
        else{
            sum += (double)(brackets[0][1] * income) / 100;
            return sum;
        }
        while(i < brackets.length && income2 > 0){
            if(brackets[i][0] <= income){
                sum += (double)((brackets[i][0] - brackets[i - 1][0]) * brackets[i][1]) / 100;
                income2 = income - brackets[i][0];
                i++;
            }
            else{
                sum += (double)(income2 * brackets[i][1]) / 100;
                break;
            }
        }
        return sum;
    }
}

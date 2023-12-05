package Leetcode;

public class leetcode1288 {
    public static void main(String[] args) {
        int[][]a = {{0,10},{5,12}};
        System.out.print(removeCoveredIntervals(a));

    }
    public static int removeCoveredIntervals(int[][] intervals) {
        int [][] a= new int[intervals.length][2];
        int temp;
        int count = a.length;
        if(count == 1)
            return 1;
        for(int i =0;i < a.length;i++){
            a[i][0] = intervals[i][0];
            a[i][1] = intervals[i][1];
        }
        for(int i = a.length - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(a[j][0] < a[j+1][0]){
                    temp = a[j][0];
                    a[j][0] = a[j+1][0];
                    a[j+1][0] = temp;
                    temp = a[j][1];
                    a[j][1] = a[j+1][1];
                    a[j+1][1] = temp;
                }
            }
        }
        for(int i = 0;i < a.length - 1;i++){
            for(int j = i + 1;j < a.length;j++){
                if(a[i][1] <= a[j][1]){
                    count--;
                    break;
                }
            }
        }
        if(a[a.length -2][0] == a[a.length - 1][0] && a[a.length -2][1] == a[a.length - 1][1] )
            count --;
        return count;
    }
}

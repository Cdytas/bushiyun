package Leetcode;

public class leetcode240 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.print(searchMatrix(a,26));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        for(int index = 0;index < matrix[0].length;index++){
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(matrix[mid][index] == target)
                    return true;
                else if(matrix[mid][index] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            low = 0;
            high = matrix.length - 1;
        }
        return false;
    }

}

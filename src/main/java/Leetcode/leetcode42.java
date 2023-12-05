package Leetcode;

public class leetcode42 {
    public static void main(String[] args) {
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int b[] = {4,2,0,3,2,5};
        System.out.println(trap(b));
    }
    public static int trap(int []height){
        int left= 0,right;
        int sum = 0;
        while(left < height.length - 2){
            right = left +1;
            while(true) {
                if (height[left] > height[right]) {
                    right++;
                    if(right == height.length){
                        left++;
                        break;
                    }
                }
                else{
                    if(right - left >= 2){
                        for(int i =left + 1;i < right;i++){
                            sum += height[left] - height[i];
                        }
                        left = right;
                        break;
                    }
                    else{
                        left++;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}

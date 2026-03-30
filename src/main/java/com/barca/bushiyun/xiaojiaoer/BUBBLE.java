package com.barca.bushiyun.xiaojiaoer;

public class BUBBLE {
    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        BubbleSort(num);
        for(int x : num)
            System.out.print(x +" ");

    }
    public static void BubbleSort(int[] num){
        int i,j;
        boolean flag = false;
        for(i = num.length - 1;i > 0;i--){
            for(j = 0;j < i;j++){
                if(num[j] > num[j + 1]){
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;
                }
            }
            if(flag == false)
                break;
            else
                flag = false;
        }
    }
}

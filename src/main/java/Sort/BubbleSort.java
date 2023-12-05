package Sort;

public class BubbleSort {
    public static void BubbleSort1(int[] a){   //升序
        boolean flag = false;
        for(int i = a.length - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if(flag == false)
                break;
            else
                flag = false;
        }
    }
    public static void BubbleSort2(int[] a){    //降序
        boolean flag = false;
        for(int i = a.length - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(a[j] < a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
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

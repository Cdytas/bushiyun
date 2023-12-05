package Sort;

public class SelectSort {

    public static void SelectSort1(int[] a){
        for(int i = 0;i < a.length - 1;i++){
            int min = a[i];
            int index = i;
            for(int j = i + 1;j < a.length;j++){
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }
            if(index != i){
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }

    public static void SelectSort2(int[] a){
        for(int i = 0;i < a.length - 1;i++){
            int max = a[i];
            int index = i;
            for(int j = i + 1;j < a.length;j++){
                if(a[j] > max){
                    max = a[j];
                    index = j;
                }
            }
            if(index != i){
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }
}

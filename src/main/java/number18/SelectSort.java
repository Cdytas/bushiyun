package number18;

public class SelectSort {
    public static void main(String[] args) {
        double []a = {5,6,8,4,2,1,6,4,7,11};
        sort(a);
        for(double x:a){
            System.out.print(x+" ");
        }
    }
    public static void sort(double []a){
        int index ;
        double min;
        for(int i = 0;i < a.length - 1;i++){
            index = i;
            min = a[i];
            for(int j = i + 1;j <= a.length - 1;j++){
                if(a[j] < a[index]){
                    index = j;
                    min = a[j];
                }
            }
            if(index != i){
                a[index] = a[i];
                a[i] = min;
            }
        }
    }
}

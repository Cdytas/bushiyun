package number18;

public class DiguiSelectSort {
    public static void main(String[] args) {
        double []a = {5,6,8,4,2,1,6,4,7,11};
        sort(a,0,a.length-1);
        for(double x:a){
            System.out.print(x+" ");
        }
    }
    public static void sort(double a[],int low,int high){
        if(low < high) {
            int index = low;
            double min = a[low];
            for (int i = low + 1; i <= high; i++) {
                if (a[i] < min) {
                    index = i;
                    min = a[i];
                }
            }
            a[index] = a[low];
            a[low] = min;
            sort(a, low + 1, high);
        }
    }
}

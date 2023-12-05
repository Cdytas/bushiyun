package Leetcode;

public class leetcode1792 {
    public static void main(String[] args) {
        int[][] classes = {{280,872},{108,128},{3,665},{93,972},{347,464},{443,584},{809,999},{366,398}};
        int extraStudents = 77862;
        System.out.print(maxAverageRatio(classes,extraStudents));

    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        int[] heap = new int[classes.length];
        for(int i = 0;i < classes.length;i++){
            heap[i] = i;
        }
        int n = heap.length - 1;
        for(int k = (n - 1) / 2;k >= 0;k--)
            sink(heap,classes,k,n);
        while(extraStudents != 0){
            classes[heap[0]][0]++;
            classes[heap[0]][1]++;
            sink(heap,classes,0,n);
            extraStudents--;
        }
        double sum = 0;
        for(int i = 0;i <= n;i++){
            sum += (double)classes[i][0] / (double)classes[i][1];
        }
        return sum / (n + 1);
    }

    public static void sink(int[] heap,int[][] classes,int k,int n){
        while(2 * k + 1 <= n){
            int j = 2 * k + 1;
            if(j < n && prior(classes,heap[j + 1],heap[j])) //存在右孩子且右孩子优先级更高
                j++;
            if(prior(classes,heap[k],heap[j]))     //k班优先级高于j班
                break;
            exchange(heap,k,j);
            k = j;
        }
    }


    public static boolean prior(int[][] classes,int j,int i){  //判断j班的优先级是否高于i班
        long a = (long)(classes[j][1] + 1) * classes[j][1] * (classes[i][1] - classes[i][0]);
        long b = (long)(classes[i][1] + 1) * classes[i][1] * (classes[j][1] - classes[j][0]);
        if(a < b)
            return true;
        return false;
    }

    public static void exchange(int[] heap,int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}

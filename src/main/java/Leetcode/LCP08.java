package Leetcode;

public class LCP08 {
    public static void main(String[] args) {
        int [][]increase = {{2,8,4},{2,5,0},{10,9,8}};
        int requirements[][] = {{2,11,3},{15,10,7},{9,17,12},{8,1,14}};
        int []a = getTriggerTime2(increase,requirements);
        int []b = {1,2,2,2,3,4,5,6,7,8,9};
        for(int x: a){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.print(Sequence(b,7));

    }
    public static int[] getTriggerTime1(int [][] increase,int [][]requirements){
        int []days = new int[requirements.length];
        boolean []flag = new boolean[requirements.length];
        int C = 0,R = 0,H = 0;
        int i,j;
        for(i = 0;i < increase.length;i++){
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            for(j = 0;j < requirements.length;j++){
                if(flag[j] == true)
                    continue;
                if(requirements[j][0] ==0 && requirements[j][1] == 0 && requirements[j][2] == 0){
                    flag[j] = true;
                    days[j] = 0;
                }
                if(C >= requirements[j][0] && R >= requirements[j][1] && H >= requirements[j][2]) {
                    if(flag[j] != true){
                        flag[j] = true;
                        days[j] = i + 1;
                    }
                }
            }
        }
        for(j = 0;j < requirements.length;j++){
            if(flag[j] == false)
                days[j] = -1;
        }
        return days;
    }

    public static int[] getTriggerTime2(int [][] increase,int [][]requirements){
        int []days = new int[requirements.length];
        int []daysOfC = new int[requirements.length];
        int []daysOfR = new int[requirements.length];
        int []daysOfH = new int[requirements.length];
        int []resourcesOfC = new int[increase.length];
        int []resourcesOfR = new int[increase.length];
        int []resourcesOfH = new int[increase.length];
        int C = 0,R = 0,H = 0;
        int i,j;
        for(i = 0;i < increase.length;i++){
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            resourcesOfC[i] = C;    //三个数组存储每天增加后的资源数量，递增
            resourcesOfR[i] = R;
            resourcesOfH[i] = H;
        }
        int low = 0;
        int high = increase.length - 1;
        int max;
        for(j  = 0;j < requirements.length;j ++){
            if(requirements[j][0] ==0 && requirements[j][1] == 0 && requirements[j][2] == 0){
                days[j] = 0;
                continue;
            }
            daysOfC[j] = Sequence(resourcesOfC,requirements[j][0]) + 1;
            daysOfR[j] = Sequence(resourcesOfR,requirements[j][1]) + 1;
            daysOfH[j] = Sequence(resourcesOfH,requirements[j][2]) + 1;
            if(daysOfC[j] == 0 || daysOfR[j] == 0 || daysOfH[j] == 0)
                days[j] = -1;
            else {
                int temp = (daysOfR[j] >= daysOfH[j] ? daysOfR[j] : daysOfH[j]);
                max = daysOfC[j] >= temp ? daysOfC[j] : temp;
                days[j] = max;
            }
        }
        return days;
    }

    /*public static int Erfen(int[]a,int key,int low,int high){    //递归的二分查找
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        if(key == a[mid])
            return mid;
        else if(key < a[mid])
            return Erfen(a,key,low,mid - 1);
        else
            return Erfen(a,key,mid + 1,high);
    }*/

    public static int Sequence(int []a,int key) {
        for (int i = 0; i < a.length; i++) {
            if (key <= a[i])
                return i;
        }
        return -1;
    }
}

package Leetcode;

public class leetcode1801 {
    public static void main(String[] args) {
        int[][] a = {{30,27,1},{18,9,1},{11,4,0},{21,11,0},{1,1,1},{24,20,1},{15,13,1},{13,3,0},{30,11,1}};
        int b = getNumberOfBacklogOrders(a);
        System.out.print(b);
    }


    public static int getNumberOfBacklogOrders(int[][] orders) {
        int count = 0;
        for(int i = 1;i < orders.length;i++){
            if(orders[i][2] == 0){
                for(int j = 0;j < i;j++){
                    if(orders[i][1] == 0)
                        break;
                    if(orders[j][2] == 1 && orders[j][0] <= orders[i][0]){
                        if(orders[j][1] <= orders[i][1]){
                            orders[i][1] = orders[i][1] - orders[j][1];
                            orders[j][1] = 0;
                        }
                        else{
                            orders[j][1] = orders[j][1] - orders[i][1];
                            orders[i][1] = 0;
                        }
                    }
                }
            }
            else{
                for(int j = 0;j < i;j++){
                    if(orders[i][1] == 0)
                        break;
                    if(orders[j][2] == 0 && orders[j][0] >= orders[i][0]){
                        if(orders[j][1] <= orders[i][1]){
                            orders[i][1] = orders[i][1] - orders[j][1];
                            orders[j][1] = 0;
                        }
                        else{
                            orders[j][1] = orders[j][1] - orders[i][1];
                            orders[i][1] = 0;
                        }
                    }
                }
            }
        }
        for(int i = 0;i < orders.length;i++){
            count = count + orders[i][1];
        }
        return count % (1000000000 + 7);
    }
}

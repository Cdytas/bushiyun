package Leetcode;

public class LCP03 {
    public static void main(String[] args) {
        int obstacles[][] = {{2,2}};
        String command = "URR";
        int x = 3,y = 2;
        System.out.print(robot(command,obstacles,x,y));
    }
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        int i = 0,j = 0,k = 0;
        int [][] path = new int[command.length()][2];
        while(k < command.length()){
            if(command.charAt(k) == 'U'){
                j++;
            }
            else{
                i++;
            }
            path[k][0] = i;
            path[k][1] = j;
            for(int h =0;h < obstacles.length;h++){
                    if(path[k][0]== obstacles[h][0] && path[k][1]== obstacles[h][1] )
                    return false;
            }
            if(i == x && j ==y){
                return true;
            }
            if(i > x || j > y)
                return false;
            k++;
            if(k == command.length())
                k = 0;
        }
        return false;
    }
}

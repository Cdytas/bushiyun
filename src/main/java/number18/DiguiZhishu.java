package number18;
import java.util.Scanner;
public class DiguiZhishu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        int n = input.nextInt();
        System.out.print(Zhishu(x,n));
    }
    public static double Zhishu(double x,int n){
        if(n == 1){
            return x;
        }
        else{
            return x * Zhishu(x,n-1);
        }
    }
}

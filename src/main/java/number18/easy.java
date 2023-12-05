package number18;

public class easy {
    public static void main(String[] args) {
        System.out.print(leiadd(100));
    }
    public static  int leiadd(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n+leiadd(n - 1);
        }
    }
}

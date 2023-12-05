package number18;

public class erroeTest1 {
    public static void main(String[] args) {
        xxx(123456789);
    }
    public static void xxx(double n){
        if( n != 0){
            System.out.print(n);
            xxx(n / 10);
        }
    }
}

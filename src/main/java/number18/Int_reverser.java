package number18;

public class Int_reverser {
    public static void main(String[] args) {
        String s =xMethod(1234567);
        System.out.println(s);
        System.out.print(Integer.MIN_VALUE);
    }
    public static String  xMethod(int n){
        if(n == 0){
           return "";
        }
        else{
            return ""+(n % 10)+xMethod(n / 10);
        }
    }
}

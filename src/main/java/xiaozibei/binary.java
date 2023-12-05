package xiaozibei;

public class binary {
    public static void main(String[] args) {
        System.out.print(binary(197));
    }
    public static String binary(int n){
        String s = "";
        while(n > 0){
            int m = n % 2;
            s = m + s;
            n = n / 2;
        }
        return s;
    }
}

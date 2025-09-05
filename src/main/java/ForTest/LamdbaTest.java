package ForTest;



@FunctionalInterface
interface Fu{
    void method(int x,int y);

}
public class LamdbaTest {

    public LamdbaTest(){}

    public void mm(int x, int y) {
        System.out.println(x * y);
    }

    public  static void nn(int x, int y) {
        System.out.println(x / y);
    }


    public static void main(String[] args) {
        LamdbaTest t = new LamdbaTest();
        Fu f = (int x, int y) -> System.out.println(x + y);
        f.method(30, 5);

        Fu f1 = (x, y) -> System.out.println(x - y);
        f1.method(30, 5);

        Fu f2 = t::mm;
        f2.method(30,5);

        Fu f3 = LamdbaTest::nn;
        f3.method(30, 5);

        Fu f4 = new Fu() {
            @Override
            public void method(int x, int y) {
                System.out.println(myPow(x, y));
            }
        };
        f4.method(2, 10);
    }

    public static int myPow(int x, int n) {
        int res = 1;
        int a = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= a;
            }
            a *= a;
            n >>= 1;
        }
        return res;
    }
}

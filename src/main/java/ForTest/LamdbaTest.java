package ForTest;



@FunctionalInterface
interface Fu{
    void method(int x,int y);

}
public class LamdbaTest {

    public LamdbaTest(){}

    public void mm(int x, int y) {
        System.out.println(x - y);
    }

    public  static void nn(int x, int y) {
        System.out.println(x / y);
    }


    public static void main(String[] args) {
        LamdbaTest t = new LamdbaTest();
        Fu f = (int x, int y) -> System.out.println(x + y);
        f.method(30, 5);

        Fu fl = (x, y) -> System.out.println(x * y);
        fl.method(30, 5);

        Fu f2 = t::mm;
        f2.method(30,5);

        Fu f3 = LamdbaTest::nn;
        f3.method(30, 5);

    }
}

package ForTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysfillTest {
    public static void main(String[] args) {
        Map<Integer, Integer>[] memo = new HashMap[5];
        Arrays.fill(memo, new HashMap<>());   //使用Arrays.fill填充对象类数组时，数组所有元素都指向同一片地址，也就是引用同一个对象
        memo[0].put(1,1);                                     //要避免使用这个方法来填充对象类数组，只能用来填充基本类型数组
        memo[0].put(2,2);
        System.out.println(memo[0] == memo[1]);  //memo[1]和memo[0]是同一个hash表
        System.out.println(memo[1].get(1));

    }


}

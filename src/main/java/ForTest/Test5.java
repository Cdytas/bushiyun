package ForTest;
import java.util.*;


public class Test5 {
    public static void main(String[] args) {
        char[] c = {'a','b','c'};
        List<String> list = new ArrayList<>();
        list.add(Arrays.toString(c));
        list.add(String.valueOf(c));
        list.add(new String(c));
        /*list.add("bbc");
        list.add("acd");
        list.add("aaa");
        Collections.sort(list);*/
        for (String s : list) {
            System.out.print(s + "  ");
        }
        System.out.print(list.get(1).equals(list.get(2)));

    }




}

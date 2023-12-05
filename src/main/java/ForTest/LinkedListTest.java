package ForTest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        var b = new LinkedList<String>();
        a.add("Amy");
        a.add("Alice");
        a.add("Alan");
        b.add("Bob");
        b.add("Black");
        b.add("Brown");
        b.add("Boom");
        System.out.println(a);
        System.out.println(b);

        ListIterator<String> ita = a.listIterator();
        Iterator<String> itb = b.iterator();

        while (itb.hasNext()) {
            if (ita.hasNext()) {
                ita.next();
            }
            ita.add(itb.next());
        }
        System.out.println(a);

        itb = b.iterator();
        while (itb.hasNext()) {
            itb.next();
            if (itb.hasNext()) {
                itb.next();
                itb.remove();
            }
         }
        System.out.println(b);

        a.removeAll(b);
        System.out.println(a);

    }

}

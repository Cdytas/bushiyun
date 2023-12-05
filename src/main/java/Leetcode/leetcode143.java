package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode143 {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(3);
        ListNode l3 = new ListNode(4,l5);
        ListNode l1 = new ListNode(2,l3);
        ListNode l0 = new ListNode(7,l1);
        System.out.println(l0 + " " + l1 +" " + l3 +" " + l5 );
        reorderList(l0);
        System.out.print(l0 + " " + l0.next +" " + l0.next.next +" " + l0.next.next.next);

    }


    public static void reorderList(ListNode head) {
        if(head.next == null)
            return;
        ListNode sup = head.next;
        List<ListNode> list = new ArrayList<>();
        while(sup != null){
            list.add(sup);
            sup = sup.next;
        }
        ListNode pointer = head;
        int i = 0;
        int j = list.size() - 1;
        while(i <= j){
            if(i == j){
                pointer.next = list.get(i);
                pointer = pointer.next;
                break;
            }
            pointer.next = list.get(j);
            pointer = pointer.next;
            pointer.next = list.get(i);
            pointer = pointer.next;
            i++;
            j--;
        }
        pointer.next = null;
    }
}

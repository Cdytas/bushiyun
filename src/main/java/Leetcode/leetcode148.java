package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode148 {
    public static void main(String[] args) {
        ListNode list = new ListNode(-1, new ListNode(5));
        list.next.next = new ListNode(3,new ListNode(4));
        list.next.next.next.next = new ListNode(0);
        ListNode list2 = list.next;
        ListNode list3 = list2.next;
        ListNode list4 = list3.next;
        ListNode list5 = list4.next;
        System.out.println(list +" " + list2 + " " + list3 + " " + list4 + " " + list5);
        list = sortList(list);
        list2 = list.next;
        list3 = list2.next;
        list4 = list3.next;
        list5 = list4.next;
        System.out.println(list +" " + list2 + " " + list3 + " " + list4 + " " + list5);

    }


    public static ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        ListNode start = new ListNode(head.val);
        ListNode end = start;
        ListNode head1 = head.next;
        while(head1 != null){
            if(head1.val >= end.val){
                end.next = new ListNode(head1.val);
                end = end.next;
                head1 = head1.next;
            }
            else if(head1.val <= start.val){
                ListNode list = new ListNode(head1.val,start);
                start = list;
                head1= head1.next;
            }
            else{
                ListNode st = start;
                while(head1.val > st.val){
                    if(head1.val > st.val && head1.val <= st.next.val){
                        ListNode list = new ListNode(head1.val,st.next);
                        list.next = st.next;
                        st.next = list;
                        break;
                    }
                    else{
                        st = st.next;
                    }
                }
                head1= head1.next;
            }
        }
        return start;
    }
}

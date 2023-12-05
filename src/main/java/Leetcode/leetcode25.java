package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode25 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2));
        list.next.next = new ListNode(3,new ListNode(4));
        list.next.next.next.next = new ListNode(5);
        ListNode list2 = list.next;
        ListNode list3 = list2.next;
        ListNode list4 = list3.next;
        ListNode list5 = list4.next;
        System.out.println(list +" " + list2 + " " + list3 + " " + list4 + " " + list5);
        list = reverseKGroup(list,2);
        list2 = list.next;
        list3 = list2.next;
        list4 = list3.next;
        list5 = list4.next;
        System.out.println(list +" " + list2 + " " + list3 + " " + list4 + " " + list5);
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;
        ListNode head1 = head;
        List<ListNode> list = new ArrayList<>();
        while(head1 != null){
            list.add(head1);
            head1 = head1.next;
        }
        ListNode result = list.get(k - 1);
        ListNode end = result;
        int index = k - 1;
        while(index < list.size()){
            for(int i = index;i >= (index + 1 - k);i--){
                if(i == index ){
                    if(index != k - 1){
                        end.next = list.get(i);
                        list.get(i).next = list.get(i - 1);
                    }
                    else {
                        list.get(i).next = list.get(i - 1);
                    }
                }
                else if(i == index + 1 - k){
                    end = list.get(i);
                }
                else{
                    list.get(i).next = list.get(i - 1);
                }
            }
            index = index + k;
            if(index >= list.size()){
                int m = index - k + 1;
                if(m < list.size()){
                    end.next = list.get(m);
                    break;
                }
                else if(m % k == 0){
                    end.next = null;
                    break;
                }
            }
        }
        return result;
    }


}

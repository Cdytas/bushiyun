package Leetcode;

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) {
        this.val = val;
    }
    ListNode1(int val, ListNode1 next) {
        this.val = val; this.next = next;
    }
  }

public class leetcode328 {
    public static void main(String[] args) {
        ListNode1 l6 = new ListNode1(4);
        ListNode1 l5 = new ListNode1(3,l6);
        ListNode1 l4 = new ListNode1(6,l5);
        ListNode1 l3 = new ListNode1(4,l4);
        ListNode1 l2 = new ListNode1(5,l3);
        ListNode1 l1 = new ListNode1(2,l2);
        ListNode1 l0 = new ListNode1(7,l1);
        ListNode1 list = oddEvenList(l0);
        while(list.next != null){
            System.out.print(list.val+" ");
            list = list.next;
        }
        System.out.print(list.val);
    }
    public static ListNode1 oddEvenList(ListNode1 head) {
        int count = 1;
        ListNode1 h = head;  //h用于测试链表中有几个结点
        while(h.next != null){
            count++;
            h = h.next;
        }
        if(count == 1 || count == 2)
            return head;
        ListNode1 even1 = head.next;
        ListNode1 even2 = head.next;
        ListNode1 single = head;
        int i = 1;
        while(i <= count - 1){
            if(i % 2 == 1){
                if(i == count - 1){
                    break;  //避免signle == null，导致最后的连接出错
                }
                else{
                    single.next = even2.next;
                    single = single.next;
                }
            }
            else if(i % 2 == 0){
                even2.next = single.next;
                even2 = even2.next;
            }
            i++;
        }
        single.next = even1;
        return head;
    }

}

package Leetcode;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " ";
    }

}

public class leetcode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        System.out.println(isPalindrome(l1));

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        ListNode nex = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            nex = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nex;
        }
        if (fast != null) {  //奇数个结点
            slow = slow.next;  //slow再右移一位
        }
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;  //后半段起始点
        ListNode sup1 = right.next;
        ListNode sup2 = right.next.next;
        while (right != null && sup1 != null) {  //翻转原链表的后半段,right也是翻转后的起点
            sup2 = sup1.next;
            sup1.next = right;
            right = sup1;
            sup1 = sup2;
        }
        while (head != null && right != null) {
            sup1 = head.next;
            sup2 = right.next;
            head.next = right;
            right.next = sup1;
            head = sup1;
            right = sup2;
        }
        if (sup1 != null) {  //前半段可能比后半段多一个结点
            sup1.next = null;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode l5 = new ListNode();  //用于保存头结点
        ListNode l3 = l5;
        int sum;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + flag;
            if(sum >= 10){
                l3.val = sum - 10;
                flag = 1;
            }
            else{
                l3.val = sum;
                flag = 0;
            }
            l3.next = new ListNode();
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null  && l2 == null){
            if(flag == 1){
                l3.val = 1;
                return l5;   //next的默认值为null
            }
            else{
                return l5;
            }
        }
        if(l1  != null) {
            while (l1 != null) {
                sum = l1.val + flag;
                if (sum >= 10) {
                    l3.val = sum - 10;
                    flag = 1;
                } else {
                    l3.val = sum;
                    flag = 0;
                }
                l3.next = new ListNode();
                l3 = l3.next;
                if ( l1.next == null && flag == 1) {
                    l3.val = 1;
                    return l5;
                }
                else if (l1.next == null) {
                    return l5;
                }
                l1 = l1.next;
            }
        }
        if(l2  != null) {
            while (l2 != null) {
                sum = l2.val + flag;
                if (sum >= 10) {
                    l3.val = sum - 10;
                    flag = 1;
                } else {
                    l3.val = sum;
                    flag = 0;
                }
                l3.next = new ListNode();
                l3 = l3.next;
                if ( l2.next == null && flag == 1) {
                    l3.val = 1;
                    return l5;
                }
                else if (l2.next == null) {
                    return l5;
                }
                l2 = l2.next;
            }
        }
        return l5;
    }

}

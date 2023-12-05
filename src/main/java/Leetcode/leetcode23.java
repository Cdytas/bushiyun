package Leetcode;

import java.util.List;

public class leetcode23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[1];
        ListNode list  = new ListNode(0);
        list.next = new ListNode(2);
        list.next.next = new ListNode(5);
        lists[0] = list;
        list = mergeKLists(lists);
        while(list != null){
            System.out.print(list.val +" ");
            list = list.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)
            return null;
        int[] sup = new int[n];
        int index = 0;
        for(int i = 0;i < n;i++){
            if(lists[i] != null){
                sup[index++] = i;
            }
        }
        if(index == 0)
            return null;
        n = index - 1;   //最后一个有效下标
        for(int k = (n - 1) / 2;k >= 0;k--)
            SmallSink(lists,sup,k,n);
        ListNode node = new ListNode(lists[sup[0]].val);
        ListNode head = node;
        ListNode end = node;
        lists[sup[0]] = lists[sup[0]].next;
        if(lists[sup[0]] == null){
            sup[0] = sup[n--];
            SmallSink(lists,sup,0,n);
        }
        else{
            SmallSink(lists,sup,0,n);
        }
        while(n > 0){
            node = new ListNode(lists[sup[0]].val);
            end.next = node;
            end = node;
            lists[sup[0]] = lists[sup[0]].next;
            if(lists[sup[0]] == null){
                sup[0] = sup[n--];
                SmallSink(lists,sup,0,n);
            }
            else{
                SmallSink(lists,sup,0,n);
            }
        }
        while(lists[sup[0]] != null){
            node = new ListNode(lists[sup[0]].val);
            end.next = node;
            end = node;
            lists[sup[0]] = lists[sup[0]].next;
        }
        return head;
    }


    public static void SmallSink(ListNode[] lists,int[] sup,int k,int n){
        while(2 * k + 1 <= n){
            int j = 2 * k + 1;
            if(j < n && Less(lists,sup[j + 1],sup[j])) //右孩子比左孩子小
                j++;
            if(Less(lists,sup[k],sup[j]))     //父节点比小孩子小
                break;
            ExchangeForInt(sup,k,j);
            k = j;
        }
    }

    public static boolean Less(ListNode[] lists,int i,int j){
        return lists[i].val < lists[j].val;
    }

    public static void ExchangeForInt(int[] sup, int i, int j){
        int temp = sup[i];
        sup[i] = sup[j];
        sup[j] = temp;
    }
}

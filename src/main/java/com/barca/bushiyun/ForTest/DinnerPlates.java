package com.barca.bushiyun.ForTest;
import java.util.*;
public class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> list; //存放数据
    private Deque<Integer> deque;  //存放可插入的下标
    private int n;   //总栈的数量

    public static void main(String[] args) {
        DinnerPlates exec = new DinnerPlates(1);
        exec.push(1);
        exec.push(2);
        exec.popAtStack(1);
        exec.pop();
        exec.push(1);
        exec.push(2);
        exec.pop();
        exec.pop();
    }

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<Stack<Integer>>();
        deque = new ArrayDeque<Integer>();
        n = 0;
    }

    public void push(int val) {
        if (!deque.isEmpty()) {
            int index = deque.pop();
            Stack<Integer> stack = list.get(index);
            stack.push(val);
            if (stack.size() < capacity) {
                deque.push(index);  //还可以继续添加
            }
        }
        else {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            if (stack.size() < capacity) {
                deque.add(n);  //还可以继续添加
            }
            list.add(stack);
            n++;
        }
    }

    public int pop() {
        return popAtStack(n - 1);
    }

    public int popAtStack(int index) {
        if (index >= n || index < 0) {
            return -1;
        }
        Stack<Integer> stack = list.get(index);
        if (stack.isEmpty()) {
            return -1;
        }
        int res = stack.pop();
        Stack<Integer> sup = new Stack<>();
        boolean flag = false;
        while (!deque.isEmpty()) {
            if (deque.peek() < index) {
                sup.push(deque.pop());
            }
            else {
                flag = true;
                if (deque.peek() == index) {
                    break;
                }
                else {
                    deque.push(index);
                    break;
                }
            }
        }
        if (!flag) {
            deque.push(index);
        }
        while (!sup.isEmpty()) {
            deque.push(sup.pop());
        }
        while (n > 0 && list.get(n - 1).isEmpty()) {
            list.remove(n - 1);
            if (!deque.isEmpty() && deque.peekLast() == n - 1) {
                deque.removeLast();
            }
            n--;
        }
        return res;
    }
}

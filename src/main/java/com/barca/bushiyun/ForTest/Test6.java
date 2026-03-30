package com.barca.bushiyun.ForTest;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.add(3)); //add将元素插到队尾，添加成功会返回true，push是void方法，无返回值
        queue.push(4);   //双端队列，push将元素插到队头
        System.out.println(queue.pop());
        System.out.println(queue.poll());   //当栈中元素为空时，poll()选择返回null，pop()选择抛出异常
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
        System.out.println(queue.poll()); //返回null
        System.out.println(queue.pop()); //抛出异常
        
    }

}

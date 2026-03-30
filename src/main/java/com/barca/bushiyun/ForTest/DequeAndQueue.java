package com.barca.bushiyun.ForTest;

import java.util.*;


public class DequeAndQueue {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();  //Deque接口实现了Queue接口，且具有自己的一些新方法
        deque.push(1);
        deque.push(2);
        deque.add(3);
        for (int x : deque) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(deque.removeLast());
        for (int x : deque) {
            System.out.print(x + " ");
        }
    }

}



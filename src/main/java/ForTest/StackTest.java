package ForTest;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(3);
        stack1.push(4);
        stack2.push(3);
        stack2.push(4);
        System.out.println(stack1.peek() == stack2.peek());   //==比较的是Integer类对象的引用，用equals方法比较基本类型数值更合适
        System.out.print(stack1.peek().equals(stack2.peek()));


    }
}

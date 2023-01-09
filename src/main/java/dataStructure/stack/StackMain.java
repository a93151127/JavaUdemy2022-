package dataStructure.stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //將數值放入stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);
        //取出一個數值,因stack是先進後出,所以這邊6會先被取出
        System.out.println(stack.pop());
        System.out.println(stack);
        //查看最後一個元素,不會被取出
        System.out.println(stack.peek());
        System.out.println(stack);
        //將元素移除
        while(!stack.isEmpty()){
            stack.pop();
        }
        System.out.println(stack);
    }
}

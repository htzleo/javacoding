package code_practice;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    private void stack2Tostack1(){
        while (!stack2.isEmpty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }

    public void push(int num){
        stack2.push(num);
    }

    public int pop(){
        if(stack1.isEmpty()){
            this.stack2Tostack1();
        }
        return stack1.pop();
    }

    public int top(){
        if(stack1.isEmpty()){
            this.stack2Tostack1();
        }
        return stack1.peek();
    }

}

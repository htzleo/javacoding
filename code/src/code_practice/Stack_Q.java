package code_practice;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_Q {
    public Queue<Integer> queue1 = new LinkedList<Integer>();
    public Queue<Integer> queue2 = new LinkedList<Integer>();

    // 将queue1中元素移入queue2,留下最后一个。
    public void moveItems(){
        while(queue1.size()!=1){
            queue2.offer(queue1.poll());
        }
    }

    // 交换两个队列
    public void swapQueue(){
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    //zeng push
    public void push(int x){
        queue1.offer(x);
    }

    public void pop() {
        moveItems();
        queue1.poll();
        swapQueue();
    }

    public int top() {
        moveItems();
        int item = queue1.poll();
        swapQueue();
        queue1.offer(item);
        return item;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

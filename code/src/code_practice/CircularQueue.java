package code_practice;

public class CircularQueue {
    int[] circularArray;
    int front, rear, size;

    public CircularQueue(int n){
        this.circularArray = new int[n];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isFull(){
        return size == circularArray.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int ele){
        if (isFull()){
            throw new RuntimeException("Queue is full");
        }
        rear = (front+size)%circularArray.length;
        circularArray[rear] = ele;
        size+=1;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int ele = circularArray[front];
        front = (front+1)%circularArray.length;
        size -= 1;
        return ele;
    }
}

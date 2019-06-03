package code_practice;

public class Queue_test {
    private QueueNode dummy, tail;
    public Queue_test(){
        dummy = new QueueNode(-1);
        tail = dummy;
    }
    //当我们要加入一个元素时，也就是从队尾中加入一个元素，
    // 只需要新建一个值为val的node节点，然后tail.next=node，
    // 再移动tail节点到tail.next
    public void enqueue(int val){
        QueueNode node = new QueueNode(val);
        tail.next = node;
        tail = node;
    }
    //当我们需要删除队头元素时，
    //只需要将dummy.next变为dummy.next.next，
    // 这样就删掉了第一个元素，这里需要注意的是，
    // 如果删掉的是队列中唯一的一个元素，
    // 那么需要将tail重新与dummy节点重合
    public int dequeue(){
        int ele = dummy.next.val;
        dummy.next = dummy.next.next;

        if (dummy.next == null){
            tail = dummy;
        }
        return ele;
    }

    public  int peek(){
        int ele = dummy.next.val;
        return  ele;
    }

    public boolean isEmpty(){
        return dummy.next == null;
    }
}
class QueueNode{
    public int val;
    public QueueNode next;
    public QueueNode(int value){
        val = value;
    }
}
package code_practice;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    class ListNode{
        public int val, key;
        public ListNode next;

        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }

    }

    private int capacity, size;
    private ListNode dummy, tail;

    //存节点之前的节点，方便修改 从dummy 开始
    private Map<Integer, ListNode> keyToPrev;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    private  void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curt = prev.next;

        if (tail == curt){
            return;
        }
        prev.next=prev.next.next;
        tail.next= curt;
        if (prev.next!= null){
            keyToPrev.put(prev.next.key,prev);
        }
        keyToPrev.put(curt.key,tail);
        tail = curt;
    }

    public int get(int key) {
        //不再里面
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }

        //在里面 挪到后面 1，2，3-> 1,3,2
        moveToTail(key);

        // the key has been moved to the end
        return tail.val;
    }
    public void set(int key, int value) {
        // get method will move the key to the end of the linked list
        //再其中，挪到后面
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }
        //不存在
        if (size < capacity) {
            size++;
            ListNode curt = new ListNode(key, value);
            tail.next = curt;
            keyToPrev.put(key, tail);

            tail = curt;
            return;
        }

        // replace the first node with new key, value
        //复用第一个node
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);

        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);

        moveToTail(key);
    }
    @Test
    public static void main(String[] args){
        String p = "abab";
        String s = "xyz abc xyz abc";
        System.out.println(p);
    }

}

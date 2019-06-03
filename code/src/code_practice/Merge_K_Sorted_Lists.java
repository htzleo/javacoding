package code_practice;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Merge_K_Sorted_Lists {
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
 }
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val-o2.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null||lists.size()==0){
            return null;
        }
        Queue<ListNode> quw = new PriorityQueue<>();
        for (int i = 0;i<lists.size();i++){
            if(lists.get(i)!= null){
                quw.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!quw.isEmpty()){
            ListNode head = quw.poll();
            tail.next = head;
            tail = head;
            if (head.next!=null){
                quw.add(head.next);
            }
        }
        return dummy.next;
    }
}

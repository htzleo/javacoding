package code_practice;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class top_k_largest_numbers {
    public int[] topk(int[] nums, int k) {
        // write your code here
        Queue<Integer> minheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i:nums){
            minheap.add(i);
            if (minheap.size()>k){
                minheap.poll();
            }
        }

        int[] res = new int[k];
        for (int i=0;i<k;i++){
            res[k-i-1]=minheap.poll();
        }
        return res;
    }
    @Test
    public void test(){
        int a = 1/0;
    }
}

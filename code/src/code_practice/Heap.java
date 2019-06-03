package code_practice;

import org.junit.Assert;
import org.junit.Test;

public class Heap {
    private void siftup(int[] A, int k) {
        while (k!=0){
            int father = (k-1)/2;
            if (A[k]<A[father]){
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;

            k = father;
        }
    }
    public void heapify(int[] A){
        for (int i = 0;i<A.length;i++){
            siftup(A,i);
        }
    }
    @Test
    public void test(){
        int[] A = {4,10,3,5,1,2};
        heapify(A);
        for (Integer i:A
             ) {
            System.out.println(i);
        }
    }
}

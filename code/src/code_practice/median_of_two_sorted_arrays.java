package code_practice;

import org.junit.Test;

public class median_of_two_sorted_arrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length+B.length;
        if (len%2 == 0){
            return findKth(A,B,0,0,len/2+1);
        }
        else{
            int s = findKth(A,B,0,0,len/2)
                    + findKth(A,B,0,0,len/2+1);
            return s/2.0;
        }
    }
    ///find kth number of merge
    public int findKth(int[] A,int[] B,int A_start, int B_start, int k){

        if (A_start>A.length){
            return B[B_start+k-1];
        }
        if (B_start>B.length){
            return A[A_start+k-1];
        }

        if(k==1){
            return Math.min(A[A_start],B[B_start]);
        }
        int Aindex = A_start + k/2-1;
        int Bindex = B_start + k/2-1;
        int Akey = Aindex <A.length ?
                A[Aindex]:Integer.MAX_VALUE;
        int Bkey = Bindex <B.length ?
                B[Bindex]:Integer.MAX_VALUE;
        if(Akey<Bkey){
            return findKth(A,B,Aindex,B_start,k-k/2);
        }else{
            return findKth(A,B,A_start,Bindex,k-k/2);
        }
    }
    @Test
    public void test(){
        int[] A = {1,2,3,4,5,6};
        int[] B = {2,3,4,5};
        System.out.println(findMedianSortedArrays(A,B));
    }
}

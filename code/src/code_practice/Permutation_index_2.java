package code_practice;

import org.junit.Test;

public class Permutation_index_2 {
    public static long permutationIndex(int[] A) {
        long res=1;
        int permutation;
        for (int i = 0;i<A.length;++i){
            long count = 0;
            long factor = 1;
            for (int j = i+1;j<A.length;++j){
                if (A[i]>A[j]){
                    count++;
                }
            }
            if (count>0){
                permutation = A.length-i-1;
                res +=(count*factor(permutation));
            }

        }
        return res;
    }
    private static long factor(long index){
        long factor =1;
        while(index>0){
            factor=factor*index;
            index--;
        }
        return factor;
    }
    @Test
    public static void main(String[] args){
        System.out.println(factor(3));
        int[] A = {2,1,4};
        System.out.println(permutationIndex(A));
    }

}

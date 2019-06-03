package code_practice;

import org.junit.Test;

import java.util.Arrays;

public class Permutation_index {

    public static long PermutationIndex(int[] A){
        long permutation = 1;
        long result = 0;
        for (int i = A.length - 2; i >= 0; --i) {
            int smaller = 0;
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[i]) {
                    smaller++;
                }
            }
            result += smaller * permutation;
            permutation *= A.length - i;
        }
        return result + 1;
    }
    @Test
    public static void main(String[] args){
        int[] nums = new int[]{2,2,7,5,4,3,2,2,1};
        System.out.println(PermutationIndex(nums));

        for(int i=0;i<=3;i++){
            System.out.print("loop"+i+" ");
            for(int j=0;j<10;j++){
                if(j==3){
                    break;
                }
                System.out.print("j="+j+" ");
            }
            System.out.println();

        }
    }
}

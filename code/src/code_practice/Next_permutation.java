package code_practice;

import org.junit.Test;

import java.util.Arrays;

public class Next_permutation {
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] nums){
        int n = nums.length;
        if (nums.length<=1){
            return;
        }
        int i = n-1;
        while (i>0 && nums[i]<=nums[i-1]){
            i--;
        }
        System.out.println("i"+i);
        if(i != 0){
            int j = nums.length-1;
            while (nums[i-1]>nums[j]){
                j--;
            }
            swap(nums,i-1,j);
        }
        reverse(nums,i,nums.length-1);
    }

    @Test
    public static void main(String[] args){
        int[] nums = new int[]{2,2,7,5,4,3,2,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

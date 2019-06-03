package code_practice;

import org.junit.Test;

import java.util.Arrays;

public class Next_permutation_s2 {

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
        int firstSmall = -1;
        int i = n-2;
        for (;i>=0;i--){
            if (nums[i]<nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1){
            reverse(nums,0,nums.length-1);
            return;
        }

        int firstLarge = -1;
        int j = n-1;
        for (;j>firstSmall;j--){
            if (nums[i]<nums[j]){
                break;
            }
        }


        swap(nums,i,j);

        reverse(nums,i+1,nums.length-1);
    }

    @Test
    public static void main(String[] args){
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

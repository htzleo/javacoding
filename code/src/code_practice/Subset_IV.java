package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_IV {
    /**
     *非递归版本，利用二进制的方式逐个枚举 subsets
     * 解法思路：进制转换.
     *
     * 1 << n is 2^n .
     * each subset equals to an binary integer between 0 .. 2^n - 1
     *
     * e.g. [a, b, c], n = 3
     *
     * 0 -> 000 -> [ ] # 0 = not include, 1 = include.
     * 1 -> 001 -> [a] # list[0] = a, list[1] = b, list[2] = c, index 1,2 both empty
     * 2 -> 010 -> [b]
     * 3 -> 011 -> [a, b]
     * 5 -> 101 -> [a, c]
     * ..
     * 7 -> 111 -> [a, b, c]
     */
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]

        for (int i = 0;i<(1<<n);i++){
            List<Integer> subset = new ArrayList<>();
            for (int j=0;j<n;j++){
                // check whether the jth digit in i's binary representation is 1
                if ((i&(1<<j))!=0){
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    @Test
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        //System.out.println(1<<4);
        List<List<Integer>> test = subsets(nums);
        for (List<Integer> i:test) {
            System.out.println(i);
        }

    }
}

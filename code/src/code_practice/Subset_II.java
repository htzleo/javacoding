package code_practice;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     * 2^n subsets
     * 递归：实现方式，一种实现DFS算法的一种方式
     * 使用比较通用的深度优先搜索方法, 从前往后找
     * []
     * [1]
     * [1, 2]
     * [1, 2, 3]
     * [1, 3]
     * [2]
     * [2, 3]
     * [3]
     */
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        if (nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(),nums,0, res);
        return  res;
    }
    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private static void helper(ArrayList<Integer> subset, int[] nums,
                               int index, List<List<Integer>> result){
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        result.add(new ArrayList<Integer>(subset));

        for(int i = index;i<nums.length;i++){
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i+1,result);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size()-1);

        }

    }

    @Test
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> test = subsets(nums);
        for (List<Integer> i:test) {
            System.out.println(i);
        }

    }
}

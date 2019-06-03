package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_I {
    @Test
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> test = subsets(nums);
        for (List<Integer> i:test) {
            System.out.println(i);
        }

    }

        /**
         * @param nums: A set of numbers
         * @return: A list of lists
         * 2^n subsets
         * 使用组合类搜索的专用深度优先搜索算法。
         * 一层一层的决策每个数要不要放到最后的集合里。
         * 先找到和原数组一样的subset 再做删减元素，
         * 依次递减处理过的元素，从后往前
         * [1, 2, 3]
         * [1, 2]
         * [1, 3]
         * [1]
         * [2, 3]
         * [2]
         * [3]
         * []
         */
        private static List<List<Integer>> subsets(int[] nums) {
            // write your code here
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }

        // 1. 递归的定义
        // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
        private static void dfs(int[] nums, int index,
                         List<Integer> subset,
                         List<List<Integer>> result
                         ){
            // 2. 递归的出口
            if (index == nums.length){
                result.add(new ArrayList<Integer>(subset));
                return;
            }
            // 3. 递归的拆解
            // (如何进入下一层)

            // 选了 nums[index]
            subset.add(nums[index]);
            dfs(nums,index+1,subset,result);

            // 不选 nums[index]
            subset.remove(subset.size()-1);
            dfs(nums,index+1,subset,result);

        }


}

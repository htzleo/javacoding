package code_practice;

import org.junit.Test;

import java.util.*;

public class Subset_III {
    /**
     *使用宽度优先搜索算法的做法（BFS）
     * 一层一层的找到所有的子集
     * []
     * [1] [2] [3]
     * [1, 2] [1, 3] [2, 3]
     * [1, 2, 3]
     */
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null) {
            return res; // 空列表
        }
        Arrays.sort(nums);

        //BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<Integer>());

        while (!queue.isEmpty()){
            List<Integer> subset = queue.poll();
            res.add(subset);
            for (int i = 0;i<nums.length;i++){
                if(subset.size()==0 || subset.get(subset.size()-1)<nums[i]){
                    List<Integer> next = new LinkedList<Integer>(subset);
                    next.add(nums[i]);
                    queue.offer(next);
                }
            }
        }
        return res;
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

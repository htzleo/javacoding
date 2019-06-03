package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        Arrays.sort(nums);
        countPermutation(nums, res, new ArrayList<Integer>(),new boolean[nums.length]);
        return res;
    }
    private static void countPermutation(int[] nums,
                                         List<List<Integer>> res,
                                         List<Integer> cur,
                                         boolean[] visited){
        if (cur.size()== nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0;i<nums.length;++i){
            if(visited[i])
                continue;
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            cur.add(nums[i]);
            visited[i] = true;
            countPermutation(nums,res,cur,visited);
            cur.remove(cur.size()-1);
            visited[i] = false;
        }
    }
    @Test
    public static void main(String[] args){
        int[] num = new int[]{1,2,2};


        List<List<Integer>> res = permute(num);
        for (List<Integer> list:res
             ) {
            System.out.println(list);
        }
    }
}

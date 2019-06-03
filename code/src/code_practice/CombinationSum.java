package code_practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        List<Integer> com = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, com, target,res);
        return res;

    }
    public static void helper(int[] candidates,int index, List<Integer> cur, int target, List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = index;i<candidates.length;i++){
            if(candidates[i]>target){
                break;
            }
            //重复的只考虑一次
            if(i!=0 && candidates[i] == candidates[i-1]){
                continue;
            }
            cur.add(candidates[i]);
            helper(candidates, i, cur,target-candidates[i],res);
            cur.remove(cur.size()-1);
        }
    }

    @Test
    public static void main(String[] args){
        int[] nums = new int[]{2,3,6,7};

        List<List<Integer>>res = combinationSum(nums, 7);
        for (List<Integer> str:res) {
            System.out.println(str);
        }
    }
}

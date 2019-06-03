package code_practice;

import org.junit.Test;

import java.util.*;

public class subarray_sum {
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int sum = 0;
        map.put(0,-1);
        for (int i =0;i<len;i++){
            sum += nums[i];
            if (map.containsKey(sum)){
                res.add(map.get(sum)+1);
                res.add(i);
            }
            map.put(sum,i);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {-3,1,2,-3,4};
        List<Integer> res = subarraySum(nums);
        for (Integer i:res){
            System.out.println(i);
        }
    }
}

package code_practice;

public class maximum_subarray {
    public int maxSubArray(int[] nums) {
        // write your code here\
        if (nums == null||nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //max记录全局最大值，sum记录前i个数的和
        //minSum记录前i个数中0-k的最小值
        int presum = 0;
        int minSum = 0;
        for (int i = 0;i<nums.length;i++){
            presum += nums[i];
            max = Math.max(presum - minSum, max);
            minSum = Math.min(minSum, presum);

        }
        return max;

    }
}

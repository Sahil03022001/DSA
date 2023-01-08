package IntroToDSA.Arrays.KadanesAlgo;

public class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 1)return nums[0];
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}

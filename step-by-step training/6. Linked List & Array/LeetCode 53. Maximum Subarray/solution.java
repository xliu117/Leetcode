/***
//dp
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int largestsum = dp[0];
   
        for(int i = 1; i < nums.length; i++){
            if (dp[i-1] < 0) dp[i] = nums[i];
            else if(dp[i-1] >= 0) dp[i] = nums[i] + dp[i-1];
            if(dp[i] > largestsum){
                largestsum = dp[i];
               
            }

        }
        return largestsum;
    }
}*/

//Greedy
class Solution{
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(sum < 0){
                sum = 0;
            }
            sum = sum + nums[i];
            max = Math.max(max,sum);
        }
        return max;
}
}

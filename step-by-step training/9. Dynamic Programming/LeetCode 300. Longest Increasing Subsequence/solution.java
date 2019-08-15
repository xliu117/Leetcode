/***
 //solution1:dp
//time:O(n^2) there are two for loops traversing in the nums array.
//space:O(n)  the int[n] dp array is used.
class Solution {
    public int lengthOfLIS(int[] nums) {
        //corner cases
        if(nums.length == 0 || nums == null){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        
        //considering dp
        //dp[i] represents the length of the longest increasing subsequene possible considering the array elements upto the ith index.
        int[] dp = new int[nums.length];
        dp[0]= 1;
        int maxans = 1;
        for(int i = 1; i < nums.length; i++){
            int maxval = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
            
        }
        return maxans;
    }
}
*/



//2. DP with binary search
class Solution{
    public int lengthOfLIS(int[] nums){
        int[] tails = new int[nums.length];
        int size = 0;
        for(int x : nums){
            int i = 0, j = size;
            while(i != j){
                int m = (i+j)/2;
                if(tails[m] < x){
                    i = m+1;
                }else{
                    j = m;
                }
            }
            tails[i] = x;
            if(i == size){
                ++size;
            }
    }
        return size;
}
}

//time:O(nlogn)
//space:O(n)

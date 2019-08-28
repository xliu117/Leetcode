 /***
//BFS
class Solution{
    public int jump(int[] nums){
        if(nums.length <= 1){
            return 0;
        }
        
        int curMax = 0;
        int level = 0, i = 0;
        
        while(i <= curMax){
            int furthest = curMax;
            for(;i<=curMax;i++){
                furthest = Math.max(furthest,nums[i] + i);
                if(furthest >= nums.length - 1){
                    return level + 1;
                }
            }
            level++;
            curMax = furthest;
        }
        return -1;
    }
}*/

class Solution{
    public int jump(int[] nums){
        int[] dp = new int[nums.length];//dp[i] indicated the minimum step to get to i.
        dp[0]=0;
        int curIndex = 0;
        int curMax = 0;
        int max = nums[0];//the furthest we can get right now.
        
        for(int i = 1; i < nums.length; i++){
            
            //the furtest place we can get from the indexes we can get right now
            curMax = Math.max(curMax, nums[i] + i);
            
            if(i<max){
                //inside the scope of index we can get, so the minimum step is dp[curIndex] +1
                dp[i] = dp[curIndex] + 1;
            }else if (i == max){//if i is at the end of the scope right now, update the next max scope and the curIndex.
                dp[i] = dp[curIndex] + 1;
                max = curMax;
                curIndex = i;
            }
        }
        
        return dp[nums.length - 1];
    }
}

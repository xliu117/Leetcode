 
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
}

/***
//dp
class Solution {
    public boolean canJump(int[] nums) {
        boolean jumpStatus[] = new boolean[nums.length];
        jumpStatus[0] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(jumpStatus[j] == true && j + nums[j] >= i){
                    jumpStatus[i] = true;
                    break;
                }
            }
        }
        return jumpStatus[nums.length -1];
    }
}
//time O(n^2)
*/

//gready
class Solution{
    public boolean canJump(int[] nums){
        int maxReach = 0;
        for(int i = 0; i < nums.length; i++){
            if(i<= maxReach){
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            if(maxReach >= nums.length - 1){
                return true;
            }
            
        }
        return false;
    }
}
//time O(n)

//solution1:slow runner & fast runner
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        
        return i+1;
    }
}

//time O(n), each of i and j traverses at most n steps
//space O(1), in place.

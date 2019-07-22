class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        
        if(nums.length == 0) return 0;
        
        
        int index = 1;
        int count = 1;
        
        for(int j = 1; j < nums.length; j++){
            if(nums[j] == nums[j-1]){
                if(count < k){
                    nums[index++] = nums[j];
                }
                count++;  
            }else{
                count = 1;
                nums[index++] = nums[j];
            } 
        }
        return index;
    }
}

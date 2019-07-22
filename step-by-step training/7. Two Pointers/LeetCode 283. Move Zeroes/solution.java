class Solution {
    public void moveZeroes(int[] nums) {
        //two pointers
        
        int i = 0;
        
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                swap(nums, i, j);
                i++;
            }
        }
             
           
    }
        
        private void swap(int[]  nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}

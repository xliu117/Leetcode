class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 1 || nums == null){
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int v = 1;
        int i = 0;
        
        while(i <= right){
           if(nums[i] < v){
               swap(nums,left++,i++);
           }
            else if(nums[i] > v){
                swap(nums,i,right--);
            }
            else{
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int x, int y){
         int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

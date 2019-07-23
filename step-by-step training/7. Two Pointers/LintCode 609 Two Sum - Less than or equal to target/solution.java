class Solution{
   public int twoSum5(int[] nums, int target){
        if(nums == null || nums.length < 2){
            return 0;
         }
         
         
         Arrays.sort(nums);
         
         int left = 0;
         int right = nums.length - 1;
         int count = 0;
         
         while(left < right){
             if(nums[left] + nums[right] <= target){
                 count += right - left;
                 left++;
             }
             else{
                 right--;
             }
             
         }
         return count;
         }
      }
      

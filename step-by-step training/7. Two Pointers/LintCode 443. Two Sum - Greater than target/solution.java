class Solution{
    public int twoSum2(int[] nums, int target){
        if(nums == null || nums.length == 0){
             return 0;
        }
        
        
        Arrays.sort(nums);
        
        
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
              if(nums[left] + nums[right] > target){
                     count += right - left;
                     right--;
               }else{
                     left++;
               }
         }
         return count;
      }
 }     
               

class Solution{
    public int partitionArray(int[] nums, int k){
         if(nums == null || nums.length == 0){
             return 0;
         }
         
         int left = 0;
         int right = nums.length - 1;
         
         while(left <= right){
             while(left <= right && nums[left] < k){
                 left++;
             }
             
             while(left <= right && nums[right] >= k){
                 right--;
              }
              
             if(left <= right){
                  int temp = nums[left];
                  nums[left]=nums[right];
                  nums[right] = temp;
                  left++;
                  right--;
             }
          }
          return left;
             
       
            
     }
}     

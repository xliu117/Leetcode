class Solution{
   public int twoSumCloest(int[] nums, int target){
   
       Arrays.sort(nums);
       
       int min = Integer.MAX_VALUE;
       
       int left = 0;
       int right = nums.length -1;
       
       while(left < right){
             int sum = nums[left] + nums[right];
            if(sum > target){
                 int gap  = Math.abs(sum - target);
                 if(gap < min){
                     min = gap;
                 }
                 right--;
             }
             else{
                 int gap  = Math.abs(sum - target);
                 if(gap < min){
                     min = gap;
                 }
                 left++;
             }
        }
        
        return min;
        }
   }     
                 
       

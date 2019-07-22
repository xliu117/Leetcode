class Solution{
  public int deduplication(int[] nums){
       if(nums == null || nums.length == 0){
           return 0;
        }
        
        Arrays.sort(nums);
        
        
        int index = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[index] != nums[j]){
                 index++;
                 nums[index] = nums[j];
             }
          }
          
          
          return index + 1;
          
      }
  }    

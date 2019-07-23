class Solution{
    public int twoSum6(int[] nums, int target)[
          int count = 0;
          
          if(nums.length < 2 || nums == null){
               return 0;
          }
          
          Arrays.sort(nums);
          
          int i = 0; 
          int j = nums.length - 1;
          
          while(i < j){
              int sum = nums[i] + nums[j];
              if(sum == target){
                  count++;
                  i++;
                  j--;
                  while(i < j && nums[i] == nums[i-1]){
                        i++;
                   }
                  while( i < j && nums[j] == nums[j+1]){
                        j--;
                   }
                  
               }
               else if(sum < target){
                   i++;
            
               }
               else if(sum > target){
                   j--;
                  
               }
          }
          
          
          return count;
          }
   }            

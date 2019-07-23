class Solution{
    public int twoSum6(int[] nums, int target)[
          int count = 0;
          
          if(nums.length == 0){
               return 0;
          }
          
          Arrays.sort(nums);
          
          int i = 0; 
          int j = nums.length - 1;
          
          while(i < j){
              int sum = nums[i] + nums[j];
              if(sum == target){
                  count++;
                  while(i == 0 || nums[i] == nums[i-1]){
                        i++;
                   }
                  while(j == nums.length - 1 || nums[j] == nums[j+1]){
                        j--;
                   }
                  continue;
               }
               if(sum < target){
                   i++;
                   continue;
               }
               if(sum > target){
                   j--;
                   continue;
               }
          }
          
          
          return count;
          }
   }            

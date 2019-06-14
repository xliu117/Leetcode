class Solution{
     public int mountainSequence(int[] nums){
             //corner case 
             if(nums.length == 0) return -1;
             
             int lo = 0;
             int hi = nums.length - 1;
             
             while(lo+1 < hi){
                int mid = lo + (hi - lo)/2;
                if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]){
                    return nums[mid];
                }
                
                else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]){
                     hi = mid;
                }
                
                else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]){
                      lo = mid;
                }
                
              }
                
              return nums[lo] < nums[hi] ? nums[hi] : nums[lo];
      }
}
                
                
            

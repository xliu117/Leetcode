class Solution{
    public int lastPostion(int[] nums, int target){
           // corner case
           if(nums.length == 0 || nums == null) return -1;
           
           int lo = 0;
           int hi = nums.length - 1;
           
           while(lo+1 < hi){
                int mid = lo + (hi - lo)/2;
                
                if(nums[mid] == target){
                        lo = mid;
                }
                else if (nums[mid] < target){
                        lo = mid;
                }
                else if ( nums[mid]> target){
                        hi = mid;
                }
            }
            
            if(nums[hi] == target) return hi;
            if(nums[lo] == target) return lo;
            if(nums[hi] != target && nums[lo] != target) return -1;
  }

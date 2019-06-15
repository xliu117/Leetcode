class Solution {
    public int findMin(int[] nums) {
        //corner cases
       if(nums.length == 0 || nums == null) return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo+1 < hi){
            int mid = lo + (hi - lo)/2;
            
            if(nums[lo] < nums[hi]){
                hi = mid;
            }
            else if (nums[lo] > nums[hi] && nums[mid] > nums[lo]){
                lo = mid;
            }else if(nums[lo]>nums[hi] && nums[mid] < nums[lo]){
                hi = mid;
            }
        }
        
        return Math.min(nums[lo],nums[hi]);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        //corner cases
        if(nums.length == 0) return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        
        while(lo+1 < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if (nums[lo] < nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
            
            
            
           
        //assume no duplicates
        if(nums[lo] == target) return lo;
        if(nums[hi] == target) return hi;
        return -1;
        
    }
}

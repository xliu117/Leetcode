class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target) return 0;
            else return -1;
        }
        
        
        int lo = 0; 
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                lo = mid + 1;
            }
            if(nums[mid] > target){
                hi = mid - 1;
            }
            
        }
        return -1;
    }
}

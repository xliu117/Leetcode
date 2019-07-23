class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3 || nums == null){
            return -1;
        }
        
        Arrays.sort(nums);
        
        
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}

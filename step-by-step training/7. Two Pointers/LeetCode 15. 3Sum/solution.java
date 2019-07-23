class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(nums.length < 3 || nums == null){
            return results;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length - 1;
            twoSum(nums,left, right, target, results);
        }
        
        return results;
    }
    
    
    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> results){
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[left]);
                list.add(nums[right]);
                results.add(list);
                left++;
                right--;
                
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                while(right > left && nums[right] == nums[right + 1]){
                    right--;
                }
            }
            
            else if (sum > target){
                right--;
            }
            else{
                left++;
            }
        }
    }
}

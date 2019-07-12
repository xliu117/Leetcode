class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(nums.length == 0 || nums == null){
            return results;
        }
        
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();
        
        search(nums, results, list, 0);
        return results;
    }
    
    private void search(int[] nums,
                       List<List<Integer>> results,
                       List<Integer> list,
                       int startIndex){
        results.add(new ArrayList<Integer>(list));
        
        for(int i = startIndex; i < nums.length; i++){
            if(i != startIndex && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            search(nums,results,list,i+1);
            list.remove(list.size()-1);
        }
    
    }
}

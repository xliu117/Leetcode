class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            return results;
        }
        
        Arrays.sort(nums);
        
        List<Integer> subset = new ArrayList<Integer>();
        
        search(nums,subset,results, 0);
 
        return results;
    }
    
    private void search(int[] nums,
                        List<Integer> subset,
                        List<List<Integer>> results,
                        int startPos){
        
        results.add(new ArrayList(subset));
        
        for(int i = startPos; i < nums.length; i++){
            subset.add(nums[i]);
            search(nums,subset,results,i+1);
            subset.remove(subset.size()-1);
        }
        return;
    }
}


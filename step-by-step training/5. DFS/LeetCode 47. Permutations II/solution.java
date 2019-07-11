class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(nums.length == 0 || nums == null){
            return results;
        }
        
        
        Arrays.sort(nums);
        
        boolean[] visit = new boolean[nums.length];
        
        List<Integer> list = new ArrayList<>();
        
        search(nums, results, list,visit);
        return results;
    }
    
    private void search(int[] nums,
                       List<List<Integer>> results,
                       List<Integer> list,
                       boolean[] visit){
        if(list.size() == nums.length){
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visit[i] || (i != 0 && !visit[i-1] && nums[i] == nums[i-1])){
                continue;
            }
            
            visit[i] = true;
            list.add(nums[i]);
            search(nums, results, list ,visit);
            list.remove(list.size()-1);
            visit[i] = false;
        }
        return;
    }
}

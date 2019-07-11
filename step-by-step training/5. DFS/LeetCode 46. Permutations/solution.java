class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return results;
        }
        List<Integer> list = new ArrayList<>();
        search(nums,results,list);
        return results;
    }
    
    private void search(int[] nums,
                       List<List<Integer>> results,
                       List<Integer> list
                      ){
        if(list.size() == nums.length){
            results.add(new ArrayList(list));
            return;
        }
        
        for(int i = 0; i< nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            
            list.add(nums[i]);
            search(nums,results, list);
            list.remove(list.size() - 1);
        }
       // return;
    }
}

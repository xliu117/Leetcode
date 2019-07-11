class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null){
            return results;
        }
        
        Arrays.sort(candidates);
        
        List<Integer> subset = new ArrayList<>();
        
        search(candidates, target, results, subset,  0);
        return results;
    }
    
    private void search(int[] candidates, int target, List<List<Integer>> results, List<Integer> subset, int startIndex){
        
        if(target==0){
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(i != startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target < candidates[i]){
                break;
            }
            subset.add(candidates[i]);
            search(candidates,target - candidates[i], results, subset, i);
            subset.remove(subset.size()-1);
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null){
             return results;
        }
        
        Arrays.sort(candidates);
        
        List<Integer> list = new ArrayList<>();
        
        search(candidates, results, list, target, 0);
        return results;
    }
    
    private void search(int[] candidates,
                       List<List<Integer>> results,
                       List<Integer> list,
                       int target, 
                       int startIndex){
        
        if(target == 0){
            results.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = startIndex; i < candidates.length; i++){
            if(i != startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target < candidates[i]){
                break;
            }
            list.add(candidates[i]);
            search(candidates, results, list, target - candidates[i], i+1);
            list.remove(list.size() - 1);
        }
    }
}

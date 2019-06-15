class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = arr.length;
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo<hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] >= x){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        
        int left = hi - 1;
        int right = hi;
        
        while(k-- >0){
            int l_gap = Integer.MAX_VALUE;
            int r_gap = Integer.MAX_VALUE;
            if(left >=0){
                l_gap = Math.abs(x - arr[left]);
            }
            if(right < arr.length){
                r_gap = Math.abs(x - arr[right]);
            }
            if(l_gap <= r_gap){
                left--;
            }else{
                right++;
            }
        }
        
    
        
        for(int q = left+1; q < right; q++){
            res.add(arr[q]);
        }
        return res;
    }
}
    
    

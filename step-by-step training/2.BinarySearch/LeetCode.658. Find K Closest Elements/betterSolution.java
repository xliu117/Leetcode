class Solution{
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int lo = 0, hi = arr.length - k;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        
          //return subarray
        List<Integer> res = new ArrayList(k);
        for(int i = 0; i < k; i++){
            res.add(arr[lo+i]);
        }
        return res;
        
    }
}



/***

class Solution{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //List<Integer> res = new ArrayList<>();
       
        int lo = 0;
        int hi = arr.length - k - 1;
        
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            //for subarray starting at mid with size k+1, we compare element of two ends to eliminate the loser
            if(Math.abs(x - arr[mid]) > Math.abs(x-arr[mid+k])){
                lo = mid + 1; // arr[mid] is the one further away from x, eliminate range[lo,mid]
            }else{
                hi = mid - 1;//arr[mid+k] is the one further away, all[mid,hi]will have similar situation, eliminate them
            }
        }
        
        //return subarray
        List<Integer> res = new ArrayList(k);
        for(int i = 0; i < k; i++){
            res.add(arr[lo+i]);
        }
        return res;
    }
}
*/
//idea:
// 1) res will be a consecutive subarray of k size
// 2) say if we need to pick 4 elements, now we r looking at 5 elem n1, n2, n3, n4, n5.
    // we need to compare two ends:diff(x,n1) and diff(x, n5), the number with bigger diff on the end will be eleminated
    //lo and hi: range of all possible start of subarray with size k + 1, so we could compare both ends.
    
    /***
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
 */
 


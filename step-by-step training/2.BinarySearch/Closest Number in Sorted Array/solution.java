//Binary search
//Time: O(logn)
class Solution{
    public int closestNumber(int[] A, int target){
            // corner case
            if(A.length == 0) return -1;
        
            int lo = 0;
            int hi = A.length -1;
            
            
            while(lo+1 < hi){
                int mi = lo + (hi-lo)/2;
                if(A[mi] == target){
                        return mi;
                }
                        
                elseif(A[mi] < target){
                    lo = mi;
                }
                
                elseif(A[mi] > target){
                     hi = mi;
                }
             }
             
        if(target <= A[lo]) return lo;
        else if (A[hi] <=target) return hi;
        else{ return (Math.abs(A[lo]-target) < Math.abs(A[hi]-target)) ? lo : hi;}
         
  }

            

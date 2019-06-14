class Solution{
    public int closestNumber(int[] Array, int target){
            int lo = 0;
            int hi = Array.length -1;
            
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
             
         return (Math.abs(A[lo]-target) < Math.abs(A[hi]-target)) ? lo : hi;
         
  }

            

/***
//two pass
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length == 0){
            return false;
        }
        if(A.length == 1){
           return true;
        } 
        
        if(A[0] <= A[A.length - 1]){
            for(int i = 1; i < A.length; i++){
                if(A[i-1] > A[i]){
                    return false;
                }
            }
        }else{
                 for(int i = 1; i < A.length; i++){
                if(A[i-1] < A[i]){
                    return false;
                }
            }
        }
        
        
        
        return true;
    }
}
*/


//once pass
class Solution{
    public boolean isMonotonic(int[] A){
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 0; i < A.length - 1; ++i){
            if(A[i] > A[i+1])
                increasing = false;
            if(A[i] < A[i+1])
                decreasing = false;
        }
        
        return increasing || decreasing;
    }
}
//O(n)

class Solution{
     public int totalOccurrence(int[] A, int target){
           //corner case
           if(A.length == 0) return -1;
           
           //first convege to find 
           int lo = 0;
           int hi = A.length - 1;
           
           while(lo+1 < hi){
               //find the first occured i
               int mid = lo + (hi - lo)/2;
               
               if(A[mid]>=target){
                    hi = mid;  
                  }else{
                    lo = mid;
                  }
            }
            
            int firstindex=0;
            if(nums[hi] == target){firstindex = hi;}
            else if(nums[lo] == target){firstindex = lo;}
            else return 0;
            
            
            //run second time binary search to find the last occured target
            int lo = 0;
            int hi = A.length -1
            while(lo + 1 < hi){
                 int mid = lo + (hi - lo)/2;
                 if(A[mid]<=target){
                     lo = mid;
                      }
                  else{
                     hi = mid;
                      }
                }
                
                
             int lastindex = 0;
             if(A[hi] == target){ lastindex = hi;}
             else{ lastindex = start;}
             
             return lastIndex - firstindex + 1;
                
                

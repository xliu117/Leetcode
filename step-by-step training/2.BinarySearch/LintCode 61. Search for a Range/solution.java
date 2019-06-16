public class Solution{
    public int[] searchRange(int[] A, int target){
         if(A.length == 0 || A == null) return new int[] {-1,-1};
         
         int start = 0;
         int end = A.length - 1;
         
         while( start + 1 < end){
                int mid = start + (end - start)/2;
                
                if(A[mid] >= target){
                         end = mid;
                         }
                else{
                         start = mid;
                         }
                         
                }
           
           int startIndex = -1;
           if(A[start] == target) startIndex == start;
           else if (A[end] == target) startIndex == end;
           else return new int[] {-1, -1};
           
           
           //again
           int start = 0;
         int end = A.length - 1;
         
         while( start + 1 < end){
                int mid = start + (end - start)/2;
                
                if(A[mid] <= target){
                         start = mid;
                         }
                else{
                         end = mid;
                         }
                         
                }
                
                
          int endIndex = -1;
          if(A[end]==target) endIndex == end;
          else if (A[start] == target) endIndex == start;
          
          
          return new int[] { startIndex, endIndex};
          }
      

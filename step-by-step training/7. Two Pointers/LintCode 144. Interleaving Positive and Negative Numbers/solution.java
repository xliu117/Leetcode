class Solution{
   public int[] rerange(int[] A){
      if(A == null || A.length < 3){
         return A;
      }
      
      int n = A.length;
      
      int countPositive = 0;
      
      int positiveIndex = 0;
      int pos = 1;
      int neg = 0;
      for(int i = 0; i < n; i++){
          if(A[i]> 0){
             swap(A, positiveIndex++, i);
             countPositive++;
          }
      }
      
      if(countPositive > n/2){
          pos = 0;
          neg = 1;
          
          
          int left = 0;
          int right = n - 1;
          while(left < right){
             swap(A,left,right);
             left++;
             right--;
          }
       }
       
       while(pos < n && neg < n){
          while(pos < n && A[pos] > 0)
             pos += 2;
          while(neg < n && A[neg] < 0)
             neg += 2;
          if(neg >= n || pos >= n)
             break;
          swap(A,pos,neg);
       }
       return A;
    }
    
    public void swap(int[] A, int l, int r){
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }
 }   

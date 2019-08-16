class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //check  corner case
        if(envelopes.length == 0 || envelopes == null){
            return 0;
        }
        if(envelopes[0].length != 2 || envelopes[0] == null){
            return 0;
        }
        if(envelopes.length == 1){
            return 1;
        }
        //key: how to sort
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];//if the first element is equal, for the secone element, put the larger ahead
                else
                    return arr1[0] - arr2[0]; //sort the first element from small to large
            }
        });
        
        int len = envelopes.length;
        
        int[] tails = new int[len];
        
        
        int size = 0;
        
        for(int[] envelop : envelopes){
            int i = 0, j = size;
            while(i != j){
                int  m = (i+j)/2;
                if(tails[m]< envelop[1]){
                    i = m+1;
                }else{
                    j = m;
                }
            }
            
            tails[i] = envelop[1];
            if(i == size) ++size;
        }
        return size;
       
    }
    
               
    //private boolean isEqual(int[] A, int[] B){
    //    return (A[0]==B[0] && A[0]==B[0]);
   // }           
   // private boolean isLarger(int[] A, int[] B){
   //     return (A[0] > B[0] && A[1] > B[1]);
   // }
    
  //  private boolean isSmaller(int[] A, int[] B){
   //     return (A[0]< B[0]&& A[1] < B[1]);
    }
}

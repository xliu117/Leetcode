class Solution {
    public int minSwap(int[] A, int[] B) {
        //n1/s1:the cost of making the first i-1 columns increasing if not-swapping/swapping the i-1th column
        //n2/s2:the cost of making the first i columns increaseing if not-swapping/swapping the ith column
        int n1 = 0, s1 = 1;
        for(int i = 1;i<A.length;++i){
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if(A[i-1] < A[i] && B[i-1] < B[i]){
                n2 = Math.min(n2,n1);
                s2 = Math.min(s2,s1+1);
            }
            if(A[i-1] < B[i] && B[i-1] < A[i]){//it allows exactly one of this columns swapped
                n2 = Math.min(n2,s1);//only swap column[i-1]
                s2 = Math.min(s2,n1+1);//only swap colunm[i]
            }
            n1 = n2;
            s1 = s2;

        }
        
        return Math.min(n1,s1);
    }
}

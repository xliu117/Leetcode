class Solution{
    public int dropEggs(int n){
        long ans = 0;
        for(int i = 1; ;++i){
            ans += (long) i;
            if(ans >= (long)n)
                 return i;
         }
     }
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for(int x : nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;
        //using: 
        //avoid: the value of previous answer that doesnot use the previously largest value prev.
        for(int k = 0; k <= 10000; ++k) if(count[k]>0){
            int m = Math.max(avoid,using);
            if(k - 1 != prev){
                using = k * count[k] + m;
                avoid = m;
            } else{
                using = k * count[k] + avoid;
                avoid = m;
            }
            prev = k;
        }
        return Math.max(avoid,using);
    }
}

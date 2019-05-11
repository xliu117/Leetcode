class Solution {
    private static final int MOD = 1000000007;
    public int numTilings(int N) {
       if(N == 1) return 1;
        if(N==2) return 2;
        
        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        //dp[3] = 5;
       // if(N <= 3) return (int) dp[N];
        
        for(int i = 3; i <= N; ++i){
            dp[i] = (2*dp[i-1]+dp[i-3])%MOD;
            //dp[i] %=MOD;
        }
        return (int) dp[N];
    }
}
/**
int numTilings(int N) {
    int md=1e9;
    md+=7;
    vector<long long> v(1001,0);
    v[1]=1;
    v[2]=2;
    v[3]=5;
    if(N<=3)
        return v[N];
    for(int i=4;i<=N;++i){
        v[i]=2*v[i-1]+v[i-3]; 
        v[i]%=md;
    }
    return v[N];
    
}



private static final int MOD = 1000000007;
    public int numTilings(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;
        long[] dp = new long[N + 1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % MOD;
        }
        return (int) dp[N];
        */

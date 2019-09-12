/***
//brute force 
class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for(int start = 1; start <= N; ++start){
            int target = N, x = start;
            while(target > 0)
                target -= x++;
            if(target == 0) ans++;
        }
        
        return ans;
    }
}*/

class Solution {
    public int consecutiveNumbersSum(int N) {
        while ((N & 1) == 0) N >>= 1;
        //(n & 1) == 0 will hence be true if n is even (or negative odd) and false otherwise.
        //n >> = 1 is equivalent to n = n >> 1. As such it shifts all bits to the right, which is roughly equivalent to a division by two (rounding down).
        int ans = 1, d = 3;

        while (d * d <= N) {
            int e = 0;
            while (N % d == 0) {
                N /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }

        if (N > 1) ans <<= 1;
        return ans;
    }
}
 

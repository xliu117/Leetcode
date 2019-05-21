/***
//1.brute force
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums[nums.length - 1];
        int[] count = new int[N+1];
        int n = nums.length;
        
        for(int i = 0; i < n; ++i){
            for(int j = i+1; j < n; ++j){
                ++count[Math.abs(nums[j] - nums[i])];
            }
        }
        
        for(int i = 0; i <= N; ++i){
            k -= count[i];
            if(k<=0) return i;
        }
        return 0;
    }
}
        
        /***
        //solution2
       Arrays.sort(nums);
        int WIDTH = 2 * nums[nums.length - 1];
        
        int[] multiplicity = new int[nums.length];
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == nums[i-1]){
                multiplicity[i] = 1 + multiplicity[i-1];
            }
        }
        
        int[] prefix = new int[WIDTH];
        int left = 0;
        for(int i = 0; i < WIDTH; ++i){
            while(left < nums.length && nums[left] == i) left++;
            prefix[i] = left;
        }
        
        int lo = 0;
        int hi = nums[nums.length -1] - nums[0];
        while(lo < hi){
            int mi = (lo + hi) /2;
            int count = 0;
            for(int i = 0; i < nums.length; ++i){
                count += prefix[nums[i] + mi] - prefix[nums[i]] + multiplicity[i];
            }
            if(count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}*/

//binary search + dp
class Solution{
     public int smallestDistancePair(int[] nums, int k) {
         Arrays.sort(nums);
         int n = nums.length;
         int l = 0;
         int r = nums[n-1] - nums[0];
         while(l <= r){
             int count = 0;
             int j = 0;
             int m = l + (r - l)/2;
             for(int i = 0; i < n; ++i){
                 while(j < n && nums[j] - nums[i] <= m) ++j;//降纬
                 count += j - i -1;
             }
             if(count >= k) r = m - 1;
             else l = m + 1;
             
         }
         return l;
}
}

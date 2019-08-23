/***
//solution1: sorting
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int[] distances = new int[len];
        for(int i = 0; i < len; i++){
            distances[i] = dist(points[i]);
        }
        
        Arrays.sort(distances);
        int distK = distances[K-1];
        
        int[][] ans = new int[K][2];
        int t = 0;
        for(int i = 0; i < len; i++){
            if(dist(points[i]) <= distK){
                ans[t++] = points[i];
            }
        }
        return ans;
    }
    
    private int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}


//time O(nlogn)
//space O(n)

*/


//solution2: quicksort
class Solution{
    public int[][] kClosest(int[][] points, int K){
        int len = points.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = helper(points, left, right);
            if(mid == K) break;
            if(mid < K){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return Arrays.copyOfRange(points,0,K);
    }
    
    private int helper(int[][] nums, int left, int right){
        int[] pivot = nums[left];
        while(left < right){
            while(left < right && compare(nums[right], pivot) >=0) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && compare(nums[left], pivot) <= 0) {
                left ++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    
    private int compare(int[] p1, int[] p2){
        return p1[0]*p1[0] + p1[1]*p1[1] - p2[0]*p2[0] - p2[1]*p2[1];
    }
}
 

 
 

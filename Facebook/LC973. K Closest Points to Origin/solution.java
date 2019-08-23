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



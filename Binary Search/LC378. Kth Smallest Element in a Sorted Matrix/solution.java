/***
//binary search
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}*/

//heap
public class Solution {
    public int kthSmallest(final int[][] matrix, int k) {
        int c = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            k, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
        
        queue.offer(new int[] {0, 0});
        
        while (true) {
            int[] pair = queue.poll();
            if (++c == k) {
                return matrix[pair[0]][pair[1]];
            }
            if (pair[0] == 0 && pair[1] + 1 < matrix[0].length) {
                queue.offer(new int[] {0, pair[1] + 1});
            }
            if (pair[0] + 1 < matrix.length) {
                queue.offer(new int[] {pair[0] + 1, pair[1]});
            }
        }
    }
}

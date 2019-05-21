//DP
/***
class Solution{
    public int calculateMinimumHP(int[][] dungeon){
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] hp = new int[m+1][n+1];
        //int[] lines = new int[n+1];
        //Arrays.fill(lines,Integer.MAX_VALUE);
        //Arrays.fill(hp,lines);
        Arrays.stream(hp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        hp[m][n-1] = hp[m-1][n] = 1;
        
        for(int y = m - 1; y >= 0; --y){
            for(int x = n - 1; x >= 0; --x){
                hp[y][x] = Math.max(1, Math.min(hp[y+1][x], hp[y][x+1]) - dungeon[y][x]);
            }
        }
        return hp[0][0];
    }
}
*/

class Solution {

public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    
    int m = dungeon.length;
    int n = dungeon[0].length;
    
    int[][] health = new int[m][n];

    health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

    for (int i = m - 2; i >= 0; i--) {            
        health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
    }

    for (int j = n - 2; j >= 0; j--) {
        health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
    }

    for (int i = m - 2; i >= 0; i--) {
        for (int j = n - 2; j >= 0; j--) {
            int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
            int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
            health[i][j] = Math.min(right, down);
        }
    }

    return health[0][0];
}
}

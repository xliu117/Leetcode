


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        
        
        // Create separate arrays for start and end times
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i=0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        // Sort each arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        // Create indices: sIdx ,eIdx
        int sIdx = 0;
        int eIdx = 0;
        
        // Min number of room index
        int minRooms = 0;
        
        // Find the min rooms
        while (sIdx < intervals.length) {
            if (startTimes[sIdx] >= endTimes[eIdx]) {
                minRooms -= 1;
                eIdx += 1;
            }
            
            minRooms += 1;
            sIdx += 1;
        }
        
        return minRooms;
    }
}

class Solution {
    public int scheduleCourse(int[][] courses) {
        //corner cases
        if(courses == null || courses.length == 0){
            return 0;
        }
        
        
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);//sort by the ending time
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);//max heap
        
        
        int time = 0;
        for(int i = 0; i < courses.length; i++){
            if(time + courses[i][0] <= courses[i][1]){
                time += courses[i][0];
                queue.offer(courses[i][0]);
            }
            else if(!queue.isEmpty() && courses[i][0] < queue.peek()){
                time += courses[i][0] - queue.poll();
                queue.offer(courses[i][0]);
            }
        }
        return queue.size();
    }
}

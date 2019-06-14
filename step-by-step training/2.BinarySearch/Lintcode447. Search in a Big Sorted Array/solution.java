class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader == null){
            return -1;
        }
        int index = 1;
        while(reader.get(index) < target){
            index *= 2;
        }
        
        
        int start = 0;
        int end = index;
        while(start + 1 <end){
            int mid = start + (end - start)/2;
            if(reader.get(mid) == target){
                end = mid;
            }else if(reader.get(mid) < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        
    
        if(reader.get(start) == target){
            return start;
        }
        
        if(reader.get(end) == target){
            return end;
        }
        
        return -1;
    }
}

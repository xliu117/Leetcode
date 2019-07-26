//Let's use here three pointers to track the rightmost boundary of zeros, the leftmost boundary of twos and the current element under the consideration.


//The idea of solution is to move curr pointer along the array, if nums[curr] = 0 - swap it with nums[p0], if nums[curr] = 2 - swap it with nums[p2].

class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 1 || nums == null){
            return;
        }
        
        int left = 0; // during the algorithm execution nums[idx < left] = 0;
        int right = nums.length - 1; // during the algorithm excecution nums[idx > right] = 0;
  
        int currIndex = 0;
        
        while(currIndex <= right){
            //if nums[currIndex] = 0, swap curr-th and left-th element and move both pointers to the right;
           if(nums[currIndex] ==0){
               swap(nums,left++,currIndex++);
           }
            //if(nums[currIndex] = 2), swap curr-th and right-th element. Move right pointer the the left;
            else if(nums[currIndex] ==2 ){
                swap(nums,currIndex,right--);
            }
            //if(nums[currIndex] == 1), move pointer currIndex to the right.
            else{
                currIndex++;
            }
        }
    }
    
    private void swap(int[] nums, int x, int y){
         int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

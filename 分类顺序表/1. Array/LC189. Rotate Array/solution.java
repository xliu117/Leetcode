/***
//solution1: use extra array
class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp_array = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            temp_array[(i+k)%nums.length] = nums[i];
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp_array[i];
        }
        
    }
}

//time O(n) two passes
//space O(n) extra array
*/

//solution2:reverse

class Solution{
    public void rotate(int[] nums, int k ){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

//time O(n)
//space O(1)

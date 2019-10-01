/***
//solution1:copy and move
//two pointers:
//i:slower runner
//j:faster runner
//when nums[j] equals to the given value, skip this element by incrementing j. as long as nums[j] != val, we copy nums[j] to nums[i] and increment both indexes at the same time. repeat the process until j reaches the end of the array and the new length is i.

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

//Analysis:
//time complexity: O(n) assume the array has a total of n elements, both i and j traverse at most 2n steps.
//space complexity:O(1) in place
*/

//solution2:swap
class Solution{
    public int removeElement(int[] nums, int val){
        int i = 0;
        int n = nums.length;
        while(i<n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                //reduce array size by one
                n--;
            }else{
                i++;
            }
        }
        
        return n;
    }
}

//Analysis:
//time complexity: O(n) both i and n traverse at most n steps. 
//space complexity:O(1) in place

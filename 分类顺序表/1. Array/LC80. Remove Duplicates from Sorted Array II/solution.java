/***
//normal solution
//two pointers
//slow runner & fast runner
class Solution {
    public int removeDuplicates(int[] nums) {
        //corner case
        if(nums.length <= 2) return nums.length;
        
        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++){
            if(nums[j] == nums[i] && count < 2){
                nums[++i] = nums[j];
                count++;
            }else if(nums[j] != nums[i]){
                nums[++i] = nums[j];
                count = 1;
            }
        }
        
        return i+1;
    }
}
        
*/


//Same simple solution written in several languages. Just go through the numbers and include those in the result that haven't been included twice already.


class Solution{
    public int removeDuplicates(int[] nums){
        int i = 0;
        for(int n : nums){
            if(i<2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        
        return i;
    }
}

//自己宛如智障!

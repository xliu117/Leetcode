/***
class Solution {
    public int removeDuplicates(int[] nums) {
      if(nums.length < 3){
          return nums.length;
      }
        
        int last = 2;
        int next = 2;
        while(next < nums.length){
            if(nums[last - 2] != nums[next]){
                nums[last] = nums[next];
                last++;
            }
            next++;
        }
        return last;
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

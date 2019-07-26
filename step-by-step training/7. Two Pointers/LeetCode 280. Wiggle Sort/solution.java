/***
//solution1:
//sort first and swap elements pair-wist 
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2){
            swap(nums, i , i+1);
        }
    }
    
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//analysis:
//time:O(nlogn)
//space:O(1)
*/


/***
//solution2:one-pass swap
class Solution{
    public void wiggleSort(int[] nums){
        boolean less = true;
        for(int i = 0; i < nums.length - 1; i++){
            if(less){
                if(nums[i] > nums[i+1]){
                    swap(nums,i,i+1);
                }
            }else{
                if(nums[i] < nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            less = !less;
 
        }
    }
    
     private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
*/


//solution2-1:
class Solution{
     public void wiggleSort(int[] nums){
         for(int i = 0; i < nums.length - 1; i++){
             if(((i%2 == 0) && nums[i] > nums[i + 1]) || ((i%2 == 1) && nums[i] < nums[i+1])){
                 //if((i%2 == 0) == (nums[i] > nums[i+1]))
                 swap(nums,i,i+1);
             }
         }
    
     }
    
     private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
}


//analysis: 
//time:O(n)
//space:O(1)

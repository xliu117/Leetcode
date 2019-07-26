class Solution{
    public void sortColors2(int[] colors, int k){
        if(colors == null || colors.length == 0){
            return;
        }
        
        
        partition(colors, 0, colors.length - 1, 1, k);
    }
    
    
    public void partition(int[] nums, int lo, int hi, int lowNum, int hiNum){
         if(lowNum == hiNum){
            return;
         }
         
         if(lo >= hi){
             return;
         }
         
         
         int left = lo;
         int right = hi;
         int v = (lowNum + hiNum)/2;
         int i = left;
         while(i <= right){
             if(nums[i] < v){
                 swap(nums, left++,i++);
             }
             else if(nums[i] > v){
                  swap(nums, i, right--);
             }
             else{
                 i++;
             }
        }
        
        partition(nums, lo, left - 1, lowNum, v - 1);
        partition(nums, right, hi, v + 1, hiNum);
    }
    
    private void swap(int[] nums, int x, int y){
         int tmp = nums[x];
         nums[x] = nums[y];
         nums[y] = tmp;
    }
}    
             

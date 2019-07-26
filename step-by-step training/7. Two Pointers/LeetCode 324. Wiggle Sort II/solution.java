class Solution{
 public void wiggleSort(int[] nums) {
      int[] temp = new int[nums.length];
     for(int i = 0; i < nums.length; i++){
         temp[i] = nums[i];
     }
      int n = nums.length-1;
      int k = n/2;
      int j = n;
     
      Arrays.sort(temp);
     
      for(int i = 0; i < nums.length; i++){
         nums[i] = (i % 2 == 1) ? temp[j--] : temp[k--];
     }
 }
}


//solution2:

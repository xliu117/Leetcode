
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /* two pointers from the end*/
        int i = m + n - 1, p2 = n-1, p1 = m-1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] < nums2[p2]){
                nums1[i] = nums2[p2];
                p2--;
                i--;
               
            }else if (nums1[p1] >= nums2[p2]){
                nums1[i] = nums1[p1];
                p1--;
                i--;
              
            }
           
        }
        
        if(p1 < 0){//add missing elements from nums2
            for(int j = p2; j >= 0; j--){
                nums1[j] = nums2[j];
            }
            
        } 
        
    }
}

//time O(m+n)

//space O(1)

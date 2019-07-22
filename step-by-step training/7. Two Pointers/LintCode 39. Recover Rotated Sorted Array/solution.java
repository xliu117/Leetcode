/***
Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
Challenge
In-place, O(1) extra space and O(n) time.
『三步翻转法』，以[4, 5, 1, 2, 3]为例。
首先找到分割点5和1
翻转前半部分4, 5为5, 4，后半部分1, 2, 3翻转为3, 2, 1。整个数组目前变为[5, 4, 3, 2, 1]
最后整体翻转即可得[1, 2, 3, 4, 5]
由以上3个步骤可知其核心为『翻转』的in-place实现。使用两个指针，一个指头，一个指尾，使用for循环移位交换即可。
注意：arraylist 里面存取数值要用 arraylist.get()/.set() 
*/
public class Solution{
    public void recoverRotatedSortedArray(ArrayList<Integer> nums){
        for(int p = 1; p < nums.size(); p++){
             if(nums.get(p-1) > nums.get(p)){
                 reverse(nums, 0, p - 1);
                 reverse(nums, p, nums.size()-1);
                 reverse(nums, 0, nums.size() - 1);
                 return;
                 }
         }
    }
    
    
    private void reverse(ArrayList<Integer> nums, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            int temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
            }
     }
}     

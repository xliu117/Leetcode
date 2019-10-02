#extra array

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        a = [0]*len(nums)
        
        for i in range(len(nums)):
            a[(i+k)%len(nums)] = nums[i]
            
            
        for i in range(len(nums)):
            nums[i] = a[i]
            
            
 

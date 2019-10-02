class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i, j = 0,1
        for j in range(len(nums)):
            if(nums[j] != nums[i]):
                i += 1
                nums[i] = nums[j]
        
        return i+1
                

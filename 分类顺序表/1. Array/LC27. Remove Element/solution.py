"""
#solution1
class Solution(object):
    def removeElement(self, nums, val):
       
        
        i = 0;
        for j in range(len(nums)):
            if(nums[j] != val):
                nums[i] = nums[j]
                i += 1
                
        return i
    
 """
#solution2        
class Solution(object): 
    def removeElement(self, nums, val):
        start, end = 0, len(nums) - 1
        while start <= end:
            if nums[start] == val:
                nums[start], nums[end], end = nums[end], nums[start], end - 1
            else:
                start +=1
        return start    
    
    
    

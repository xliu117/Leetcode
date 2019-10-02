
#solution1: two pointers slow & fast
class Solution(object):
    def removeDuplicates(self, nums):
        
   
        if len(nums) < 3:
            return len(nums)
        
        i = 0
        count = 1
        j = 1
        
        for j in range(1,len(nums)-1):
            if(nums[j] == nums[i] and count < 2):
                i += 1
                nums[i] = nums[j]
                count += 1
                
            elif(nums[j] != nums[i]):
                i += 1
                nums[i] = nums[j]
                count = 1
                
        return i+1        

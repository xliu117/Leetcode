#O(n) time

def firstMissingPositive(self, nums):
    for i in xrange(len(nums)):
        while 0 <= nums[i]-1 < len(nums) and nums[nums[i]-1] != nums[i]:
            tmp = nums[i]-1
            nums[i], nums[tmp] = nums[tmp], nums[i]
    for i in xrange(len(nums)):
        if nums[i] != i+1:
            return i+1
    return len(nums)+1
    
    
    
    
# O(nlgn) time
def firstMissingPositive(self, nums):
    nums.sort()
    res = 1
    for num in nums:
        if num == res:
            res += 1
    return res

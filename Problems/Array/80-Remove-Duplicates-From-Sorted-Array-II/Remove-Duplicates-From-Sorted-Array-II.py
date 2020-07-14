class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        if (n < 3): return n
        i = j = 2
        while(j < n):
            while (j < n and nums[i-2] == nums[i-1] and nums[i-1] == nums[j]):
                j += 1
            if (j < n):
                nums[i] = nums[j]
                i += 1
                j += 1
        return i
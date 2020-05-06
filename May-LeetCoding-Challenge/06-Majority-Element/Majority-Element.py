class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        half_n = len(nums) / 2
        nums_dict = {}
        for num in nums:
            if num in nums_dict:
                nums_dict[num] += 1
            else:
                nums_dict[num] = 1

        for k, v in nums_dict.items():
            if v > half_n:
                return k
            else:
                pass

class Solution1:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] == nums[mid - 1]:
                if (mid - 1 - left) % 2 == 0:
                    left = mid + 1
                else:
                    right = mid - 2
            elif nums[mid] == nums[mid + 1]:
                if (mid - left) % 2 == 0:
                    left = mid + 2
                else:
                    right = mid - 1
            else:
                return nums[mid]
        return nums[left]


class Solution2:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        res_list = list()
        for num in nums:
            if num in res_list:
                res_list.remove(num)
            else:
                res_list.append(num)
        return res_list[0]

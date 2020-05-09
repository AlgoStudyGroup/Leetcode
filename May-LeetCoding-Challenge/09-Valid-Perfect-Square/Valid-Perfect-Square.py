class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        i, s = 1, 1
        while s < num:
            i += 2
            s += i

        return s == num

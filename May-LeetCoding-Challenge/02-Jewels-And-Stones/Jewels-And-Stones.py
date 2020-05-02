class Solution1:
    def numJewelsInStones(self, J: str, S: str) -> int:
        jewel = set(J)
        res = 0
        for x in S:
            if x in jewel:  # O(1)
                res += 1
        return res


class Solution2:
    def numJewelsInStones(self, J: str, S: str) -> int:
        res = 0
        stones_dict = {}
        for s in S:
            if s in stones_dict:  # O(1)
                stones_dict[s] += 1
            else:
                stones_dict[s] = 1

        for j in J:
            if j in stones_dict:
                res += stones_dict[j]

        return res


class Solution3:
    def numJewelsInStones(self, J: str, S: str) -> int:
        res = 0
        for x in S:
            if x in J:  # O(n)
                res += 1
        return res

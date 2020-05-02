class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        jewel = set(J)
        res = 0
        for x in S:
            if x in jewel:
                res+=1
        return res

class Solution1:
    def numJewelsInStones(self, J: str, S: str) -> int:
        jewel = set(J)
        res = 0
        for x in S:
            if x in jewel:
                res+=1
        return res

class Solution2:
    def numJewelsInStones(self, J: str, S: str) -> int:
        res = 0
        stone_dict = {}
        for s in S:
            if not s in stone_dict:
                stone_dict[s] = 1
            else:
                stone_dict[s] += 1
        for j in J:
            if j in stone_dict:
                res += stone_dict[j]
        return res
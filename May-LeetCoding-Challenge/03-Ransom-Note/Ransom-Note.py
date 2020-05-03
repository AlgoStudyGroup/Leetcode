class Solution1:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if ransomNote == magazine:
            return True
        else:
            for r in ransomNote:
                if r in magazine:
                    magazine = magazine.replace(r, '', 1)
                else:
                    return False
            return True


class Solution2:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if ransomNote == magazine:
            return True
        else:
            magazines_dict = {}
            for m in magazine:
                if m in magazines_dict:
                    magazines_dict[m] += 1
                else:
                    magazines_dict[m] = 1

            for r in ransomNote:
                if r in magazines_dict and magazines_dict[r] > 0:
                    magazines_dict[r] -= 1
                else:
                    return False
            return True

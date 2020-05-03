class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if ransomNote == magazine:
            return True
        elif len(ransomNote) == len(magazine):
            return False
        else:
            for r in ransomNote:
                if r in magazine:
                    magazine = magazine.replace(r, '', 1)
                else:
                    return False
            return True

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        need = dict(collections.Counter(s1))
        window = {}
        left,right = 0,0
        while right < len(s2):
            letter = s2[right]
            if letter not in need:
                window.clear()
                left = right+1
            else:
                window[letter]=window.get(letter,0)+1
                if window==need:
                    return True
                if window[letter]>need[letter]:
                    while left<=right:
                        if s2[left]!=letter:
                            window[s2[left]] = window.get(s2[left],0)-1
                            left+=1
                        else:
                            left+=1
                            break
                    window[letter]-=1
            right+=1
        return False

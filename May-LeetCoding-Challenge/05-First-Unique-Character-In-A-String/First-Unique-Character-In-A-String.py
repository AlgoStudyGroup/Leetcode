class Solution:
    def firstUniqChar(self, s: str) -> int:
        letters_dict = {}
        for idx, letter in enumerate(s):
            if letter in letters_dict:
                letters_dict[letter][0] += 1
            else:
                letters_dict[letter] = [1, idx]

        nb = 0
        for letter, value in letters_dict.items():
            if value[0] == 1:
                nb += 1
                if nb == 1:
                    return value[1]
                else:
                    pass
            else:
                pass

        if nb == 0:
            return -1

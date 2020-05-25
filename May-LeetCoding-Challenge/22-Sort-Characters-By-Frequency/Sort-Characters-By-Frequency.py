class Solution:
    def frequencySort(self, s: str) -> str:
        s_dict = {}
        for c in s:
            if not c in s_dict:
                s_dict[c] = s.count(c)
        sorted_s_dict = {k: v for k, v in sorted(s_dict.items(),
                                                 key=lambda item: item[1],
                                                 reverse=True)}
        output = ''
        for c, nb in sorted_s_dict.items():
            output += c * nb

        return output

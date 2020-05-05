class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> num(26, 0);
        int ans = -1;
        for (auto &t: s) num[t - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (num[s[i] - 'a'] == 1) return i;
        return -1;
    }
};
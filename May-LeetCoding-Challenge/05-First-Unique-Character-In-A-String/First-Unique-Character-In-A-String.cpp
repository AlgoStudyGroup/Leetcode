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

class Solution2 {
public:
    int firstUniqChar(string s) {
        /*  
         * O(n + 26)
         */
        
        int first = -1;
        int tab[26];
        
        memset(tab, -1, 26*sizeof(int));
        
        for (int i = 0 ; i < s.size() ; ++i) {
            if (tab[s[i] - 'a'] == -1) {
                tab[s[i] - 'a'] = i;
            } else if (tab[s[i] - 'a'] != -2){
                tab[s[i] - 'a'] = -2;
            }
        }
        
        for (int i = 0 ; i < 26 ; ++i) {
            first = min((unsigned int)tab[i], (unsigned int)first);
        }
        
        return first + (first == -2);
    }
};

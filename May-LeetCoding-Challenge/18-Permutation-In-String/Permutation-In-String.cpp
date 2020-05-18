class Solution {
public:
    bool check(vector<int>& diff){
        for (int i = 0; i < 26; i++)
            if (diff[i] != 0) return false;
        return true;
    }
    
    bool checkInclusion(string s1, string s2) {
        int n = s2.length();
        int m = s1.length();
        
        if (m > n) return false;
        
        vector<int> diff(26, 0);
        for (int i = 0; i < m; i++) {
            diff[s2[i] - 'a']++;
            diff[s1[i] - 'a']--;
        }
        
        vector<int> ans;
        if (check(diff)) return true;
       
        
        for (int i = m; i < n; i++){
            diff[s2[i] - 'a']++;
            diff[s2[i-m]-'a']--;
            if (check(diff)) return true;
        }
        
        return false; 
    }
};

class Solution2 {
public:
    bool checkInclusion(string s1, string s2) {
        vector<int> h1(26,0);
        int count = s1.size();
        int right = 0, left = 0;
        int l_idx;
        
        for (char &c : s1) ++h1[c-'a'];
        
        for (int right = 0; right < s2.size() ; ++right) {
            count -= h1[s2[right]-'a']-- > 0;
            if (count == 0) {
                l_idx = right - s1.size() + 1;
                for (; left < l_idx; ++left)
                    count += h1[s2[left]-'a']++ >= 0;

                if (count == 0)
                    return true;
            }
        }
        
        return false;
    }
};

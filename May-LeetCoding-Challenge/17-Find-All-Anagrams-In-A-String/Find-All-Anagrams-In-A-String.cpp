class Solution {
public:
    bool check(vector<int>& diff){
        for (int i = 0; i < 26; i++)
            if (diff[i] != 0) return false;
        return true;
    }
    
    vector<int> findAnagrams(string s, string p) {
        int n = s.length();
        int m = p.length();
        
        if (m > n) return vector<int>();
        
        vector<int> diff(26, 0);
        for (int i = 0; i < m; i++) {
            diff[s[i] - 'a']++;
            diff[p[i] - 'a']--;
        }
        
        vector<int> ans;
        if (check(diff)) ans.push_back(0);
       
        
        for (int i = m; i < n; i++){
            diff[s[i] - 'a']++;
            diff[s[i-m]-'a']--;
            if (check(diff)) ans.push_back(i - m + 1);
        }
        
        return ans;
    }
};
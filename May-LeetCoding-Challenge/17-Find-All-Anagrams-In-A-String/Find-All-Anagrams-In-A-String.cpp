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

class Solution2 {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res, m(256, 0);
        int left = 0, right, count = p.size(), n = s.size();
        
        if (count > n) return res;
        for (char &c : p) ++m[c];
        for (right = 0 ; right < p.size()-1 ; ++right)
            count -= m[s[right]]-- >= 1;

        while (right < n) {
            count -= m[s[right++]]-- >= 1;
            if (count == 0) res.push_back(left);
            count += m[s[left++]]++ >= 0;
        }
        return res;
    }
};

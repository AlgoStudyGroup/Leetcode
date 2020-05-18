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
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> m;
        
        for (auto s: strs) {
            string tmp = s;
            sort(tmp.begin(), tmp.end());
            m[tmp].push_back(s);
        }
        
        vector<vector<string>> ans;
        for (auto it = m.begin(); it != m.end(); it++)
            ans.push_back(it->second);
        
        return ans;
    }
};
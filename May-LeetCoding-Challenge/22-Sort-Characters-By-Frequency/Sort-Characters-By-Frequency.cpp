class Solution {
public:
    string frequencySort(string s) {
        map<char, int> m;
        for (auto &c: s) m[c]++;
        
        vector<pair<int, char>> v;
        for (auto p: m) v.push_back(make_pair(p.second, p.first));
        sort(v.begin(), v.end(), greater<pair<int, char>>());
        
        string ans;
        for (auto p: v)
            for (int i = 0; i < p.first; i++) ans += p.second;
        return ans;
    }
};



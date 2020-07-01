class Solution {
public:
    int n;
    vector<string> ans;
    map<string, vector<string>> a;
    
    
    bool dfs(string s){
        ans.push_back(s);
        if (ans.size() == n + 1) return true;
        for (auto& t: a[s]){
            if (t != "") {
                string tmp = t;
                t = "";
                if (dfs(tmp)) return true;
                t = tmp;
            }   
        }
        ans.pop_back();
        return 0;
    }
    
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        n = tickets.size();
        
        for (int i = 0; i < n; i++)
            a[tickets[i][0]].push_back(tickets[i][1]);
        
        for (int i = 0; i < n; i++)
            sort(a[tickets[i][0]].begin(), a[tickets[i][0]].end());
        dfs("JFK");
        return ans;
    }
};
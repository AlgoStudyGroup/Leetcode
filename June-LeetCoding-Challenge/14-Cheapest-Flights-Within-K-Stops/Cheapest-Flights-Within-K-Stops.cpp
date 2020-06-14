class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        vector<vector<int>> a(n, vector<int>(n, 0));
        for (int i = 0; i < flights.size(); i++)
            a[flights[i][0]][flights[i][1]] = flights[i][2];
        
        
        vector<vector<int>> dp(K+2, vector<int>(n, 0));
        
        for (int i = 0; i < n; i++) dp[0][i] = 1000000000;
        dp[0][src] = 0;
        
        int ans = min(dp[0][dst], 1000000000);
        for (int i = 1; i <= K+1; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = 1000000000;
                for (int k = 0; k < n; k++)
                    if (a[k][j])
                        dp[i][j] = min(dp[i][j], dp[i-1][k] + a[k][j]);
            }
            ans = min(ans, dp[i][dst]);
        }
        return (ans == 1000000000)?-1:ans;
    }
};

class Solution2 {
    // algo dijkstra
public:
    typedef tuple<int, int, int> typeTuple; // (AccumulatedCost, cityId, stopUsed)
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        
        priority_queue<typeTuple, vector<typeTuple>, greater<typeTuple>> neighs;
        
        unordered_map<int, vector<pair<int, int>>> g;
        for (auto& v : flights)
            g[v[0]].emplace_back(v[1], v[2]);

        neighs.emplace(0, src, 0);

        while (!neighs.empty()) {
            auto t = neighs.top();
            int cost = get<0>(t); // accumulated cost
            int u = get<1>(t); // city u -> city v
            int stopused = get<2>(t);
            neighs.pop();
            
            if (u == dst) 
                return cost;

            if (stopused > K) continue;

            for (auto p : g[u]) 
                neighs.emplace(cost + p.second, p.first, stopused + 1); // increment stopused
            
            }
        return -1;

    }
};

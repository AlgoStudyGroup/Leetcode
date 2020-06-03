// Time Complexity O(n^2), space complexity O(n^2)
class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int N = costs.size();
        if (N == 0) return 0;
        int n = N / 2;
        
        vector<vector<int>> dp(N+1, vector<int>(n+1, 0));
        for (int i = 1; i <= N; i++) dp[i][0] = dp[i-1][0] + costs[i-1][1];
        
        
        for (int i = 1; i <= N; i++) 
            for (int j = 0; j <= min(n, i); j++){
                dp[i][j] = dp[i-1][j-1] + costs[i-1][0];
                if (i-1 >= j)
                    dp[i][j] = min(dp[i][j], dp[i-1][j] + costs[i-1][1]);
            }
        return dp[N][n];
    }
};

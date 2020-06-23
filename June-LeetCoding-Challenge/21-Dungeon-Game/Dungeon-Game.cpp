class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int n = dungeon.size();
        int m = dungeon[0].size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 1000000000));
        dp[n-1][m] = dp[n][m-1] = 1;
        
        for (int i = n-1; i>=0; i--)
            for (int j = m-1; j>=0; j--)
                dp[i][j] = max(min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
        
        return dp[0][0];
    }
};
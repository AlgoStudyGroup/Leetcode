class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if (n == 0) return 0;
        int m = matrix[0].size();
        
        vector<vector<int>> up(n+1, vector<int>(m+1, 0));
        vector<vector<int>> left(n+1, vector<int>(m+1, 0));
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        
        
        int ans = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++){
                up[i][j] = (matrix[i-1][j-1] == 0)?0:(up[i-1][j]+1);
                left[i][j] = (matrix[i-1][j-1] == 0)?0:(left[i][j-1]+1);
                dp[i][j] = (matrix[i-1][j-1] == 0)?0:(dp[i-1][j-1]+1);
                dp[i][j] = min(dp[i][j], min(left[i][j], up[i][j]));
                ans += dp[i][j];
            }
        return ans;
        
    }
};
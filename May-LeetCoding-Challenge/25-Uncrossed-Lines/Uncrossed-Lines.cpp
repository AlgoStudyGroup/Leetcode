// O(n^2) time, O(n^2) space
class Solution1 {
public:
    int maxUncrossedLines(vector<int>& A, vector<int>& B) {
        int n = A.size(), m = B.size();
        if (n == 0 or m == 0) return 0;
        
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
           
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++){
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                if (A[i-1] == B[j-1])
                    dp[i][j] = max(dp[i][j], dp[i-1][j-1] + 1);
            }
        return dp[n][m];
    }
};

// O(n^2) time, O(n) space
class Solution2 {
public:
    int maxUncrossedLines(vector<int>& A, vector<int>& B) {
        int n = A.size(), m = B.size();
        if (n == 0 or m == 0) return 0;
        
        vector<vector<int>> dp(2, vector<int>(m+1, 0));
        int flag = 0;        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[1-flag][j] = max(dp[flag][j], dp[1-flag][j-1]);
                if (A[i-1] == B[j-1]) 
                    dp[1-flag][j] = max(dp[1-flag][j], dp[flag][j-1] + 1);
            }
            flag = 1 - flag;
        }
        return dp[flag][m];
    }
};
// Time complexity O(n^2); Space complexity O(n^2)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(2, vector<int>(amount+1, 0));
        dp[0][0] = 1;        
        
        int flag = 1;
        for (int i = 1; i <= coins.size(); i++){
            for (int j = 0; j <= amount; j++){
                dp[flag][j] = dp[1-flag][j];
                if (j >= coins[i-1])
                    dp[flag][j] += dp[flag][j-coins[i-1]];
            }
            flag = 1 - flag;
        }
        return dp[1-flag][amount];
    }
};
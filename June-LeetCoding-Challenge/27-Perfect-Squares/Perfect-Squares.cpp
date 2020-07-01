class Solution {
public:
    vector<int> dp;
    int calc(int n){
        if (n == 0) return 0;
        if (dp[n]) return dp[n];
        int m = (int)(sqrt(n));
        int sum = n;
        for (int i = 1; i <= m; i++)
            sum = min(sum, calc(n - i * i) + 1);
        dp[n] = sum;
        return sum;
    }
    
    int numSquares(int n) {
        dp.resize(n+1);
        for (int i = 1; i <= n; i++){
            calc(i);
        }
        return dp[n];
    }
};
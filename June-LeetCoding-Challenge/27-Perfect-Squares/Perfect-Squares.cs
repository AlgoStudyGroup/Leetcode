// Runtime: 88 ms, faster than 90.00% of C# online submissions for Perfect Squares.
// Memory Usage: 16.1 MB, less than 88.06% of C# online submissions for Perfect Squares.
public class Solution {
    public int NumSquares(int n) {
        var dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            var j = 1;
            var min = n;
            while(i >= j*j){
                min = Math.Min(min, dp[i - j*j] +1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
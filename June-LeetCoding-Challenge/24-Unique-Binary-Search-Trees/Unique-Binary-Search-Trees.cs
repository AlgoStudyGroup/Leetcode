// Runtime: 40 ms, faster than 78.73% of C# online submissions for Unique Binary Search Trees.
// Memory Usage: 14.4 MB, less than 98.08% of C# online submissions for Unique Binary Search Trees.
public class Solution {
    public int NumTrees(int n) {
        var dp = new int[n+1];
        dp[0] =1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
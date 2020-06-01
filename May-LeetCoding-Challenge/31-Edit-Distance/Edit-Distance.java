/**
 * Dynamic programming, operation of previous string plus one if the last character is not the same
 * XXXb -> YYYc => operation(XXX to YYY) + 1
 * XXXm -> XXXm => operation(XXX to YYY)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m+1][n+1];

        /**
         * Construct a dp table
         * __|''|a|b|c|
         * ''| 0|1|2|3|...
         * ''| 0
         * d | 1
         * e | 2
         * f | 3
         */
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);

                // If the last character is the same, we do nothing compare to previous string
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // we chose the minimum operation of three operation: insert, delete, replace
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
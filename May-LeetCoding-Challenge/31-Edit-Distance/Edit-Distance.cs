public class Solution {
    public int MinDistance(string word1, string word2) {
            int m = word1.Length;
            int n = word2.Length;
            int[,] dp = new int[2, n + 1];

            for (int i = 0; i <= n; i++)
                dp[0, i] = i;

            for (int i = 1; i <= m; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    if (j == 0)
                        dp[i % 2, j] = i;

                    else if (word1[i - 1] == word2[j - 1])
                        dp[i % 2, j] = dp[(i - 1) % 2, j - 1];

                    else
                        dp[i % 2, j] = 1 + Math.Min(Math.Min(dp[i % 2, j - 1], // Insert 
                                           dp[(i - 1) % 2, j]), // Remove 
                                           dp[(i - 1) % 2, j - 1]); // Replace 
                }
            }

            return dp[m % 2, n];
    }
}

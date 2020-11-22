using System;

namespace _188_Best_Time_to_Buy_and_Sell_Stock_IV
{
    public class Solution
    {
        public int MaxProfit(int k, int[] prices)
        {
            if (prices == null || prices.Length <= 1) return 0;

            int len = prices.Length;

            //You can make as many as operations on array prices
            if (k >= len / 2)
            {
                int max = 0;
                for (int i = 1; i < len; i++)
                {
                    if (prices[i] > prices[i - 1])
                    {
                        max += prices[i] - prices[i - 1];
                    }
                }
                return max;
            }

            int[,] dp = new int[k + 1, len];

            for (int i = 1; i <= k; i++)
            {
                int localMax = dp[i - 1, 0] - prices[0];
                for (int j = 1; j < len; j++)
                {
                    dp[i, j] = Math.Max(dp[i, j - 1], prices[j] + localMax);
                    localMax = Math.Max(localMax, dp[i - 1, j] - prices[j]);
                }
            }
            return dp[k, len - 1];
        }
    }
}
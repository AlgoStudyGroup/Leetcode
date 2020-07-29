public class Solution {
    public int MaxProfit(int[] prices) {
        int sold = 0, hold = Int32.MinValue, rest = 0;
        for (int i=0; i<prices.Length; ++i)
        {
            int prvSold = sold;
            sold = hold + prices[i];
            hold = Math.Max(hold, rest-prices[i]);
            rest = Math.Max(rest, prvSold);
        }
        return Math.Max(sold, rest);
    }
}

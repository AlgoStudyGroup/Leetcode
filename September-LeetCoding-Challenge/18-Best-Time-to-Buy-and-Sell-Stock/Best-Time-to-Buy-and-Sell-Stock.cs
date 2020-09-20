public class Solution {
    public int MaxProfit(int[] prices) {
        if(prices == null || prices.Length == 0) return 0;
        int min=prices[0],max=0;
        for (int i=1;i<prices.Length;i++){
            min=Math.Min(min,prices[i]);
            max=Math.Max(max,prices[i]-min);
        }
        return max;
    }
}
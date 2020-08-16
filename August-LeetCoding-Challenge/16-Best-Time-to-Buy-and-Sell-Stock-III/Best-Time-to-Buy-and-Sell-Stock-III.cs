public class Solution {
    public int MaxProfit(int[] prices) {
        var oneBuyOneSell = 0;
        var twoBuyTwoSell = 0;
        var oneBuy = int.MaxValue;
        var twoBuy = int.MaxValue;
        
        for(int i=0; i<prices.Length; i++){
            var v = prices[i];
            oneBuy = Math.Min(oneBuy, v);
            oneBuyOneSell = Math.Max(oneBuyOneSell, v - oneBuy);
            twoBuy = Math.Min(twoBuy, v-oneBuyOneSell);
            twoBuyTwoSell = Math.Max(twoBuyTwoSell, v-twoBuy);
        }
        
        return twoBuyTwoSell;
    }
}
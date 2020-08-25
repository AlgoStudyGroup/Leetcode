public class Solution {
    public int MincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.Length - 1]; 
        bool[] isTravelDay = new bool[lastDay+1];
        foreach(var day in days){
            isTravelDay[day] = true;
        }
        int[] dp = new int[lastDay+1];
        for(int i=1; i<=lastDay; i++){
            if(!isTravelDay[i]){
                dp[i] = dp[i-1];
                continue;
            }
            
            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.Min(dp[i], dp[Math.Max(0, i-7)] + costs[1]);
            dp[i] = Math.Min(dp[i], dp[Math.Max(0, i-30)] + costs[2]);
        }
        return dp[lastDay];
    }
}

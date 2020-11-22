namespace _1510_Stone_Game_IV
{
    public class Solution
    {
        public bool WinnerSquareGame(int n)
        {
            bool[] dp = new bool[n+1];
            for(int i=1; i<=n; i++){
                for(int j=1; j*j<=i; j++){
                    if(!dp[i -j*j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
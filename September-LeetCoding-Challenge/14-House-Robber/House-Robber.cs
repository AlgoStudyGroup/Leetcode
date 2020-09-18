public class Solution {
    public int Rob(int[] nums) {
        if(nums.Length == 0) return 0;
        
        var dp = new int[nums.Length+1];
        dp[1] = nums[0];
        for(int i=1; i<nums.Length; i++){
            dp[i+1] = Math.Max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[nums.Length];
    }
}
class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        if (n == 0) return vector<int>();
        vector<int> dp(n+1, 0);
        vector<int> prev(n+1, 0);
        
        int maxv = 0, p = 0;
        
        for (int i = 1; i <= n; i++){
            dp[i] = 1;
            prev[i] = i;
            for (int j = 1; j < i; j++){
                if (nums[i-1] % nums[j-1] == 0 and dp[j] + 1 > dp[i]){
                    prev[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxv){
                maxv = dp[i];
                p = i;
            }
        }
        
        vector<int> ans;
        while (p != prev[p]) {
            ans.push_back(nums[p-1]);
            p = prev[p];
        }
        ans.push_back(nums[p-1]);
        
        sort(ans.begin(), ans.end());
        return ans; 
    }
};
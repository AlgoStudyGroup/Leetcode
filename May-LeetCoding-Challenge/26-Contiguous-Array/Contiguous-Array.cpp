class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int n = nums.size();
        int sum = 0;
        map<int, int> min_index;
        
        int ans = 0;
        for (int i = 0; i < n; i++){
            sum += (nums[i] == 0)?-1:1;
            if (sum == 0) ans = i+1;
            else if (min_index.find(sum) == min_index.end())
                min_index[sum] = i;
            else ans = max(ans, i - min_index[sum]);
        }
        return ans;
    }
};


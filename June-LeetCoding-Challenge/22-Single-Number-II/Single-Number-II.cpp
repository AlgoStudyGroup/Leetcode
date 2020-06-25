class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++){
            int p = 1 << i;
            int sum = 0;
            for (int j = 0; j < nums.size(); j++)
                if (nums[j] &  p) sum++;
            if (sum % 3 != 0) ans += p;
        }  
        return ans;
    }
};
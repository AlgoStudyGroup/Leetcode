class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;

        set<vector<int>>s;
        int n = nums.size();
        for (int i = 0; i < n - 2; i++) {
			int left = i + 1, right = n - 1;  
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0)
                    s.insert({nums[i],nums[left++], nums[right--]}); 
                else if (sum < 0) 
                    left++;
                else
                    right--;
            }
        }
	
        for(auto v: s){
            ans.push_back(v);
        }
        return ans;
    }
};
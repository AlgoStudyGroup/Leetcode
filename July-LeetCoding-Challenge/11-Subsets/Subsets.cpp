class Solution1 {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> r;
        vector<int> sub;
        recur(r, nums, 0, sub);
        return r;
    }
    
    void recur(vector<vector<int>>& r, vector<int>& nums, int pos, vector<int> sub){
        r.push_back(sub);
        for(int i=pos, n=nums.size(); i<n; ++i){
            sub.push_back(nums[i]);
            recur(r, nums, i+1, sub);
            sub.pop_back();
        }
    }
};

class Solution2 {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        ans.push_back(vector<int>());
        for (int i = 0; i < nums.size(); i++){
            int m = ans.size();
            for (int j = 0; j < m; j++){
                vector<int> v = ans[j];
                v.push_back(nums[i]);
                ans.push_back(v);
            }
        }
        return ans;
    }
};
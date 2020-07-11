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

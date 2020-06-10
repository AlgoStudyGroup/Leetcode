class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        return distance(nums.begin(), lower_bound(nums.begin(), nums.end(), target));
    }
};


class Solution2 {
public:
    int searchInsert(vector<int>& nums, int target) {
       	return lower_bound(nums.begin(), nums.end(), target) - nums.begin();
    }
};
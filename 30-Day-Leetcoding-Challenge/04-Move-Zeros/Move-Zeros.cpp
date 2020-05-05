class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        int i = 0;
        int j = 0;
        
        while (j < n){
            while (j < n and nums[j] == 0) j++;
            if (j == n) break;
            nums[i++] = nums[j++];
        }
        for (int k = i; k < n; k++) nums[k] = 0;
    }
};
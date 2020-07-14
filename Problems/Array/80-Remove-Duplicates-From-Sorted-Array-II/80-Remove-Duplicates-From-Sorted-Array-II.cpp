class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        if (n < 3) return n;
        int i = 2, j = 2;
        while (j < n){
            while (j < n and nums[j] == nums[i-1] and nums[i-1] == nums[i-2])
                j++; 
            if (j < n)
                nums[i++] = nums[j++];
        }
        return i;
    }
};
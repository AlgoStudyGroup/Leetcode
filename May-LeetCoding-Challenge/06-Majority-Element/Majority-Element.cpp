class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int val, n = 0;
        for (auto &x: nums){
            if (n == 0) {
                val = x;
                n++;
            }
            else n += (x != val) ? -1 : 1;
        }   
        return val;
    }
};
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int a = 0, b = 0;
        do{
            a = nums[a];
            b = nums[nums[b]];
        } while (a != b);
        
        b = 0;
        while (a != b){
            a = nums[a];
            b = nums[b];
        }
        return a;
    }
};
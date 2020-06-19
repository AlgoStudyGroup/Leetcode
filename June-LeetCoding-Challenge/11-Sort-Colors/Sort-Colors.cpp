class Solution {
public:
    void swap(int& a, int& b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    
    void sortColors(vector<int>& nums) {
        int a = 0, b = nums.size()-1;
        int i = 0;
        while (i <= b){
            if (nums[i] == 2){
                swap(nums[b], nums[i]);
                b--;
                continue;
            }
        
            if (nums[i] == 0) {
                swap(nums[a], nums[i]);
                a++;
            }
            i++;
        } 
    }
};
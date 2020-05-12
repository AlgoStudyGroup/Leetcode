class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right){
            int mid = (right - left) / 2 + left;
      
            if (nums[mid] == nums[mid + 1]){
                if ((mid - left) % 2 == 0) left = mid + 2;
                else right = mid - 1;
            }
            else if (nums[mid] == nums[mid-1]){
                if ((right - mid) % 2 == 0) right = mid - 2;
                else left = mid + 1;
            }
            else  return nums[mid];
        }
        return nums[left];
    }
};
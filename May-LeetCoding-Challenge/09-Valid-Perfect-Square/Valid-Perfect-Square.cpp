class Solution {
public:
    bool isPerfectSquare(int num) {
        int left = 0, right = 46340;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid * mid == num) return true;
            else if (mid * mid < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
};
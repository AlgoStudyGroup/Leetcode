// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid))
                right = mid;
            else left = mid + 1;
        }
        return left;
    }
};


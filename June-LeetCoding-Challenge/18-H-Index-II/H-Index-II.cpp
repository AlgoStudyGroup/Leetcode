class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (n - mid <= citations[mid]) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return n - left;
    }
};
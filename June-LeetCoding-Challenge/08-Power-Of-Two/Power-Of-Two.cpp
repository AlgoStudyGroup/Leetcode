class Solution {
public:
    bool isPowerOfTwo(int n) {
        long long x = n;
        if (x == 0) return false;
        return (x & (-x)) == x;
    }
};
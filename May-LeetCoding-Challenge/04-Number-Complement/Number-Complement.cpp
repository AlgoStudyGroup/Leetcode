class Solution {
public:
    int findComplement(int num) {
        long long i = 1;
        while (i <= num) i <<= 1;
        return (i-1) ^ num;
    }
};
class Solution {
public:
    int findComplement(int num) {
        long i = 1;
        while (i <= num) i <<= 1;
        return (i-1) ^ num;
    }
};

class Solution2 {
private:
    inline int fill_bits(int v) {
        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        v |= v >> 16;
        return v;
    }
public:

    int findComplement(int num) {
        return fill_bits(num + (num==0) ) & ~num;
    }
};

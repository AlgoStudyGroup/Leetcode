class Solution {
public:
    bool isPowerOfTwo(int n) {
        long long x = n;
        if (x == 0) return false;
        return (x & (-x)) == x;
    }
};

class Solution {
public:
    int right_most_setbit(int num) { 
        int pos = 0; 
        // counting the position of first set bit 
        for (int i = 0; i < 32; i++) { 
            if (!(num & (1 << i))) 
                pos++; 
            else
                break; 
        } 
        return pos; 
    }
    
    bool isPowerOfTwo(int n) {
        if(n<=0) return false;
        else return right_most_setbit(n) == int(log2(n));
        
    }
};

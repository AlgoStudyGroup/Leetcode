class Solution1 {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t r = 0;
        
        for(int i=0; i<32; ++i){
            if(n&(1<<i))
                r = r|(1<<(32-i-1));
        }
        
        return r;
    }
};

class Solution {
    public int findComplement(int num) {
        int numBits = 0, origin = num;
        
        // get number of bits in binary representation
        while (num > 0){
            num >>= 1;
            numBits++;
        }

        return ((1 << numBits) - 1) ^ origin;
    }
}
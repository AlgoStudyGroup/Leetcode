class Solution {
public:
    int hammingDistance(int x, int y) {
        int z = x xor y;
        int ans = 0;
        while (z){
            z -= z & (-z);   
            ans ++;
        }
        return ans;
    }
};
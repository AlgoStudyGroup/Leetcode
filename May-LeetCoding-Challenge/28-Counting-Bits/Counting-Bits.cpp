class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans(num+1, 0);
        int m = 1;
        for (int i = 1; i <= num; i++){
            if (i == m){
                ans[i] = 1;
                m <<= 1;
            }
            else ans[i] = ans[i - m/2] + 1;
        }
        return ans;
    }
};
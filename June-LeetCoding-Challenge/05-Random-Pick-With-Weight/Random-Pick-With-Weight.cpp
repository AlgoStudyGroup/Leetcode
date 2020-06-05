class Solution {
public:
    vector<int> sum;
    
    Solution(vector<int>& w) {
        if (w.size() > 0){
            sum.push_back(w[0]);
            for (int i = 1; i < w.size(); i++) sum.push_back(sum[i-1] + w[i]);
        }
    }
    
    int pickIndex() {
        int p = (rand() % sum[sum.size() - 1]) + 1;
        return lower_bound(sum.begin(), sum.end(), p) - sum.begin();
    }
};
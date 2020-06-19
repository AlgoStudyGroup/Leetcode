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

class Solution2 {
    // space: O(n)
    map<int, int> m;
    int sum;
public:
    // time O(n log n)
    Solution(vector<int>& w) {
        sum = 0;
        for (int i = 0; i < w.size(); ++i) {
            sum += w[i];
            m[sum] = i;
        }
    }
    
    // time O(log n)
    int pickIndex() {
        return m.upper_bound(rand()%sum)->second;
    }
};

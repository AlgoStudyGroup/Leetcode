class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        if (n == 0) return vector<int>();
        vector<int> dp(n+1, 0);
        vector<int> prev(n+1, 0);
        
        int maxv = 0, p = 0;
        
        for (int i = 1; i <= n; i++){
            dp[i] = 1;
            prev[i] = i;
            for (int j = 1; j < i; j++){
                if (nums[i-1] % nums[j-1] == 0 and dp[j] + 1 > dp[i]){
                    prev[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxv){
                maxv = dp[i];
                p = i;
            }
        }
        
        vector<int> ans;
        while (p != prev[p]) {
            ans.push_back(nums[p-1]);
            p = prev[p];
        }
        ans.push_back(nums[p-1]);
        
        sort(ans.begin(), ans.end());
        return ans; 
    }
};

class Solution {/* time: O(n*n), space: O(n) */
public:
    /* 
     * the idea is for each num in nums, 
     * find all multiple of num.
     * each num have a count of previous multiple
     */
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int i;
        if (!nums.size())
            return {};

        map<int, int> m;
        map<int, int>::iterator it;
        vector<pair<int, int>> dp(nums.size());
        unsigned int acc, num;
        int largest_last_index = 0;
        int largest_subcount = 0;
            
        sort(nums.begin(), nums.end());
        for (i = 0; i < nums.size(); ++i)
            m[nums[i]] = i;
        
        if (nums[0] == 1) {
            fill(dp.begin()+1, dp.end(), make_pair(0,1));
            dp[0].first = -1;
            dp[0].second = 0;
            largest_last_index = nums.size()-1;
            i = 1;
        } else {
            i = 0;
            fill(dp.begin(), dp.end(), make_pair(-1,0));
        }

        for (; i < nums.size(); ++i) {
            num = nums[i];
            acc = num << 1;
            if ((int)num > (int)acc) // solve overflow problem
                continue;
            /* find all multiple of num */
            while ((it = m.upper_bound(acc-1)) != m.end()) {
                int mod = it->first % num;
                auto &ref = dp[i];
                auto &tgt = dp[it->second];
                /* current list of multiple is larger than the old one */
                if (mod == 0 && ref.second >= tgt.second) {
                    /* move target into biger list */
                    tgt.first = i ;
                    tgt.second = ref.second +1;
                    if (tgt.second > largest_subcount) {
                        largest_subcount = tgt.second;
                        largest_last_index = it->second;
                    }
                }
                acc = it->first - mod + num;
                if ((int)num > (int)acc) // solve overflow problem
                    break;
            }
        }
        
        vector<int> ret;
        while (largest_last_index >= 0) {
            ret.push_back(nums[largest_last_index]);
            largest_last_index = dp[largest_last_index].first;
        }
        return ret;
    }
};

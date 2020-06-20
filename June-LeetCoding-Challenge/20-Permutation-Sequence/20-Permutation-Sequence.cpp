class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> v(n);
        iota(v.begin(), v.end(), 1);
        while(k-1){
            next_permutation(v.begin(), v.end());
            --k;
        }
        string r;
        transform(v.begin(), v.end(), back_inserter(r), [](const int num) -> char { return num + '0'; });
        
        return r;
    }
};

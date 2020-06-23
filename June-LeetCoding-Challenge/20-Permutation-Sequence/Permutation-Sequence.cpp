class Solution1 {
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


class Solution2 {
public:
    string getPermutation(int n, int k) {
        vector<int> a(n, 0);
        for (int i = 0; i < n; i++) a[i] = i + 1;
        int j = 1;
        while (j < k) {
            next_permutation(a.begin(), a.begin()+n);
            j++;
        }
        
        string ans;
        for (int i = 0; i < n; i++) ans += to_string(a[i]);
        return ans;
    }
};
class Solution {
public:
    int nthUglyNumber(int n) {
        if (n == 1) return 1;
        vector<int> a(n, 0);
        a[0] = 1;
        int i = 0, j = 0, k = 0; 
        for(int p = 1 ; p < n; p++) {
            a[p] = min(2 * a[i], min(3 * a[j], 5 * a[k]));
            if(a[p] == 2 * a[i]) i++;
            if(a[p] == 3 * a[j]) j++;
            if(a[p] == 5 * a[k]) k++;
        }
        return a[n - 1];
    }
};
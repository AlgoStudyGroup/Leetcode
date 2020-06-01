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

class Solution2 {
public:
    inline int numberOfSetBits(int i)
    {
        i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }
    
    vector<int> countBits(int num) {
        vector<int> v;  
        for (int i = 0; i <= num ; ++i)
            v.push_back(numberOfSetBits(i));
        return v;
    }
};

class Solution3 {
public:
    vector<int> countBits(int num) {
        vector<int> v(num+1);
        int n = 1, src = 0;
        
        /* init */
        v[0] = 0;
        
        while ((n<<1)+n <= num) {
            for (;src<n;++src) v[src+n] = v[src]+1;
            n += n;
            memcpy(&v[n], &v[src], (n-src)*sizeof(int));
        }
        
        if (num < n*2) {
            for (;src<=num-n;++src) v[src+n] = v[src]+1;
            return v;
        }
        for (;src<n;++src) v[src+n] = v[src]+1;
        n += n;
        memcpy(&v[n], &v[src], (num-n+1)*sizeof(int));
        return v;
    }
};

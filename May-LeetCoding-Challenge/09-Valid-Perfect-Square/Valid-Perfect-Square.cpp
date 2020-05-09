class Solution1 {
public:
    bool isPerfectSquare(int num) {
        int left = 0, right = 46340;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid * mid == num) return true;
            else if (mid * mid < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
};


class Solution2 {
public:
    bool isPerfectSquare(int num) {
        if (num == 0) return true;
        for (int i = 1; num >= i; i+=2) num -= i;
        return num == 0;
    }
};


class Solution3 {
public:
    bool isPerfectSquare(int num) {
       long long x = num;
       while (x * x > num){
           x = (x + num / x) / 2;
       }
        return x * x == num;
    }
};

class Solution4 {
public:
    void get_primes(vector<int>& prime){
        prime.resize(0);
        vector<int> vis(46341, 0);
        for (int i = 2; i <= 46340; i++)
            if (!vis[i]){
                prime.push_back(i);
                vis[i] = 1;
                int j = i + i;
                while (j < 46341) {
                    vis[j] = 1;
                    j += i;
                }
            }
    }
    
    bool isPerfectSquare(int num) {
        if (num == 0) return true;

        vector<int> prime;
        get_primes(prime);
        for (int i = 0; i < prime.size(); i++){
            int m = 0;
            while (num % prime[i] == 0){
                m += 1;
                num /= prime[i];
            }
            if (m % 2 == 1) return false;
        }
        
        
        
        return (num == 1);
    }
};
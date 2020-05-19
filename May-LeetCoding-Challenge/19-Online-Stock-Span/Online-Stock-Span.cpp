// Got TLE using vector 
class StockSpanner {
public:
    int fail[10005];
    int v[10005];
    int n;
    StockSpanner() {
        n = 1;
        fail[0] = 0;
    }
    
    int next(int price) {
        v[n++] = price; 
        int i = n - 2;
        while (i > 0 and price >= v[i]) i = fail[i];
        fail[n-1] = i;
        return n - i - 1;
          
    }
};


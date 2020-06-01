/*
    Dynamic programming using idea of KMP.
    Got AC using array.
    Got TLE using vector.
*/ 
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


/*
Stack !
*/
class StockSpanner2 {
public:
    stack<pair<int, int>> st; 
    StockSpanner() {}
    
    int next(int price) {
        int sum = 1;
        
        while (!st.empty() and price >= st.top().first) {
            sum += st.top().second;
            st.pop();
        }
        st.push(make_pair(price, sum));
        return sum;
    }
};
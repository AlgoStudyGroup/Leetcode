class Solution {
public:
    int get_next(int n){
        int sum = 0;
        while(n){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    bool isHappy(int n) {
        set<int> vis;
        while(n != 1){
            vis.insert(n);
            n = get_next(n);
            if (vis.find(n) != vis.end())
                return false;
        }
        return true;
    }
};
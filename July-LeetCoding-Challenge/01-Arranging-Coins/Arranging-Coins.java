/**
 * We can treat it like a problem of Arithmetic progression with a1 = 1, d = 1
 * The sum of this arithmetic sequence is i(i+1)/2, when the sum is first big than we can get that
 * the maxmum staircase shap is i - 1
 */
class Solution {
    public int arrangeCoins(int n) {
        if(n == 0 || n == 1) return n;
        
        int m = 0;
        for(int i = 2; i <= n; i++) {
            if((Math.pow(i, 2) + i) / 2 > n) return (i-1);
        }
        
        return m;
    }
}
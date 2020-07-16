public class Solution {
    public double MyPow(double x, int n) {
        if(n < 0) return Pow(1/x, -n);
        return Pow(x, n);
    }
    
    public double Pow(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n % 2 == 0) return Pow(x * x, n/2);
        return x * Pow(x * x, n / 2);
    }
}
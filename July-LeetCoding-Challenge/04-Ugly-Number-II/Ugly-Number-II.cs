public class Solution {
    public int NthUglyNumber(int n) {
        if(n<1) return 0;
        if(n==1) return 1;
        int m2 = 0, m3 = 0, m5 = 0;
        var v = new int[n];
        v[0] =1;
        for(int i=1; i<n; i++)
        {
            v[i] = Math.Min(Math.Min(v[m2]*2, v[m3]*3), v[m5]*5);
            if(v[i] == v[m2]*2) m2++;
            if(v[i] == v[m3]*3) m3++;
            if(v[i] == v[m5]*5) m5++; 
        }        
        return v[n-1];
    }
}
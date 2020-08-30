public class Solution {
    int[] par;
    int[] cnt;
    public int LargestComponentSize(int[] A) {
        var n = A.Length;
        par = new int[n];        
        cnt = new int[n];
        var dict = new Dictionary<int, HashSet<int>>();
        for(int i=0; i<n; i++){
            int d=2, x=A[i];
            while(d*d<=x){
                if(x%d==0){
                    while(x%d ==0) x/= d;
                    if(!dict.ContainsKey(d)) 
                        dict.Add(d, new HashSet<int>());
                    dict[d].Add(i);
                }
                d++;
            }
            if(x>1){
                if(!dict.ContainsKey(x)) 
                    dict.Add(x, new HashSet<int>());
                dict[x].Add(i);
            }
        }
        
        for(int i=0; i<n; i++) par[i] = i;
        Array.Fill(cnt, 1);
        int max = 1;
        foreach(HashSet<int> h in dict.Values){
            int fir = h.First();
            foreach(var idx in h){
                Union(idx, fir);
                max = Math.Max(cnt[Find(idx)], max);
            }
        }
        return max;
    }
    private void Union(int i, int j){
        int pi = Find(i);
        int pj = Find(j);
        if(pi == pj) return ;
        par[pi] = pj;
        cnt[pj] += cnt[pi];
    }
    
    private int Find(int i){
        if(i==par[i]) return i;
        return par[i] = Find(par[i]);
    }
}
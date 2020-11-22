public class Solution {
    public int BagOfTokensScore(int[] tokens, int P) {
        Array.Sort(tokens);
        int lo=0, hi=tokens.Length-1, res=0, points=0;
        while(lo = hi){
            if(P = tokens[lo]){
                P -= tokens[lo];
                res = Math.Max(res, ++points);
                lo++;
            }
            else if(points0){
                points--;
                P += tokens[hi];
                hi--;
            }
            else{
                break;
            }
        }
        return res;
    }
}

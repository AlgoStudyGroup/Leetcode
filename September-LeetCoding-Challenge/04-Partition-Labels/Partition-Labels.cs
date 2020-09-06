public class Solution {
    public IList<int> PartitionLabels(string S) {
        if(string.IsNullOrEmpty(S)) return null;
        
        int[] largestPositionByValue = new int[26];
        for(int i=0; i<S.Length; i++){
            largestPositionByValue[S[i] - 'a'] = i;
        }
        
        var res = new List<int>();
        var start = 0;
        var end=0;
        for(int i=0; i<S.Length; i++){
            end = Math.Max(end, largestPositionByValue[S[i]-'a']);
            if(end == i){
                res.Add(end-start+1);
                start = end + 1;
            }
        }
        return res;        
    }
}
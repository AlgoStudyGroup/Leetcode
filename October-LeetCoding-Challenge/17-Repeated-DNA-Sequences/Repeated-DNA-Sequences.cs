public class Solution {
    public IList<string> FindRepeatedDnaSequences(string s) {
        if(s == null || s.Length == 0) return new List<string>();
        var seen = new HashSet<string>();
        var repeated = new HashSet<string>();
        for(int i=0; i<s.Length-9; i++){
            string curr = s.Substring(i, 10);
            if(!seen.Add(curr)){
                repeated.Add(curr);
            }
        }
        return new List<string>(repeated);
    }
}

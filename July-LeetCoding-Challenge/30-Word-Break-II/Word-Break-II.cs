public class Solution {
    private Dictionary<string, List<string>> dict = new Dictionary<string, List<string>>();
    public IList<string> WordBreak(string s, IList<string> wordDict) {
        if(dict.ContainsKey(s)){
            return dict[s];
        }
        
        var res = new List<string>();
        if(s.Length == 0){
            res.Add("");
            return res;
        }
        
        foreach(var word in wordDict){
            if(s.StartsWith(word)){
                var subList = WordBreak(s.Substring(word.Length), wordDict);
                foreach(var sub in subList){
                    res.Add(word + (String.IsNullOrEmpty(sub) ? "" : " ") + sub);
                }
            }
        }
        
        dict.Add(s, res);
        return res;
    }
}
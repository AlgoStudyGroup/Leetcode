public class Solution {
    public int TitleToNumber(string s) {
        int res = 0;
        var chars = s.ToCharArray();
        foreach(var c in chars){
            res = res*26 + (c-'A') + 1;
        }
        return res;
    }
}
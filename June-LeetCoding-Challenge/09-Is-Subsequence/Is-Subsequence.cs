public class Solution {
    
    // A faster method
    public bool IsSubsequence(string s, string t) {
        if (s == "")
            return true;
        
        if (s.Length > t.Length)
            return false;
        
        int inds = 0;
        foreach (char c in t) {
            if (s[inds] == c) {
                inds++;
                if (inds == s.Length)
                    return true;
            }
        }
        return false;
    }
    
    // A more general method
    public bool IsSubsequenceMine(string s, string t) {
        
        if (s.Length > t.Length)
            return false;
        
        // the following comparison makes the method faster
        if (s.Length == t.Length)
            return s == t;
        
        int inds = 0, indt = 0;
        while (inds < s.Length && indt < t.Length) {
            if (s[inds] == t[indt]) {
                inds++;
            }
            indt++;
        }
        return inds > s.Length-1;
    }
}

public class Solution {
    public bool IsPalindrome(string s) {
        int begin = 0;
        int end = s.Length-1;
        while(begin <= end){
            while(begin<=end && !Char.IsLetterOrDigit(s[begin])){
                begin++;
            }
            while(begin<=end && !Char.IsLetterOrDigit(s[end])){
                end--;
            }
            if(begin<=end && Char.ToLower(s[begin]) != Char.ToLower(s[end])){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}

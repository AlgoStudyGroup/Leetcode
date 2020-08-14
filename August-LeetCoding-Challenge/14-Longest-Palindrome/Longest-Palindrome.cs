public class Solution {
    public int LongestPalindrome(string s) {
        var dict = new Dictionary<char, int>();
        foreach(char c in s){
            if(!dict.ContainsKey(c)){
                dict.Add(c, 1);
            }else{
                dict[c]++; 
            }
        }
        
        var sum = 0;
        var hasOdd = false;
        var evenChars = new List<KeyValuePair<char, int>>();
        foreach(var kv in dict){
            if(kv.Value % 2 == 0){
                sum += kv.Value;
            }else if(kv.Value / 2 >= 1){
                sum += kv.Value -1;
                hasOdd = true;
            }else {
                hasOdd = true;
            }
        }
        
        sum = hasOdd ? sum +1 : sum;
        
        return sum;        
    }
}
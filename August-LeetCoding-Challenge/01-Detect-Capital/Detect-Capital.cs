public class Solution {
    
    //Solution 1: 
    public bool DetectCapitalUse(string word) {
        int count = 0;
        foreach(char c in word){
            if('Z' - c >= 0) count++;
        }
        //Count == 0 means all characters are lower case.
        //Count == word.Length mean all characters are upper case
        //Count == 1 && 'Z' - word[0] >=0 means only first character is upper case
        return (count == 0) || (count == word.Length)
            || (count == 1 && 'Z' - word[0] >=0);
    }
    
    //Solution 2
    public bool DetectCapitalUse(string word) {
        return Char.IsUpper(word[0]) 
        ? word.Substring(1).Equals(word.Substring(1).ToUpper()) || word.Substring(1).Equals(word.Substring(1).ToLower()) 
        : word.Substring(1).Equals(word.Substring(1).ToLower());
    }
}
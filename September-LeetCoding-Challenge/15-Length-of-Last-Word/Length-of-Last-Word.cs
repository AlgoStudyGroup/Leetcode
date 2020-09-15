public class Solution {

    //Solution 1
    public class Solution {
    public int LengthOfLastWord(string s) {
        if(s.Length == 0) return 0;
        
        var l = s.Split(' ').ToList();
        var i = l.Count - 1;
        while(i >= 0){
            if(l[i] == ""){
                i--;
            }
            else{
                return l[i].Length;
            }
        }
        
        return 0;
    }
}


    //Solution 2
    public int LengthOfLastWord(string s)
        {
            if (s.Length == 0) return 0;

            int beginPosition = 0;
            int endPosition = 0;
            bool hasWord = false;
            bool hasSpaceBeforeLastWord = false;

            //Start by the end of string
            for (int i = s.Length - 1; i >= 0; i--)
            {
                if (s[i] == ' ' && !hasWord)
                {
                    //This condition improves performance
                    continue;
                }
                else if (s[i] != ' ' && !hasWord)
                {
                    hasWord = true;
                    endPosition = i;
                    continue;
                }
                else if (s[i] == ' ' && hasWord)
                {
                    beginPosition = i;
                    hasSpaceBeforeLastWord = true;
                    break;
                }
            }

            //One word case
            if (endPosition - beginPosition == 0 && hasWord)
                return 1;

            //No words case
            if (endPosition - beginPosition == 0 && !hasWord)
                return 0;

            //Has word and has spaces before last words
            if (endPosition - beginPosition != 0 && hasWord && hasSpaceBeforeLastWord)
                return endPosition - beginPosition;

            //Has word and has no space before last words
            if (endPosition - beginPosition != 0 && hasWord && !hasSpaceBeforeLastWord)
                return endPosition - beginPosition + 1;

            return 0;
        }
}

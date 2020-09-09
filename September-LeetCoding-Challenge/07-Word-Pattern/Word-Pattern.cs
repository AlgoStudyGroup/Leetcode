public class Solution {
    public bool WordPattern(string pattern, string str) {
            var words = str.Split(" ");

            if (pattern.Length != words.Length) return false;

            var dict = new Dictionary<char, string>();

            for (int i = 0; i < words.Length; i++)
            {
                char c = pattern[i]; //Positionning char

                if (dict.ContainsKey(c))
                {
                    if (dict[c] != words[i])
                        return false;
                }
                else
                {
                    if (dict.ContainsValue(words[i]))
                        return false;

                    dict.Add(c, words[i]);
                }
            }

            return true;
    }
}
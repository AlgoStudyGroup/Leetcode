using System.Collections.Generic;
using System.Text;

namespace _804_Unique_Morse_Code_Words
{
    public class Solution
    {
        public int UniqueMorseRepresentations(string[] words)
        {
            var arr =
                new string[26]
                {
                    ".-",
                    "-...",
                    "-.-.",
                    "-..",
                    ".",
                    "..-.",
                    "--.",
                    "....",
                    "..",
                    ".---",
                    "-.-",
                    ".-..",
                    "--",
                    "-.",
                    "---",
                    ".--.",
                    "--.-",
                    ".-.",
                    "...",
                    "-",
                    "..-",
                    "...-",
                    ".--",
                    "-..-",
                    "-.--",
                    "--.."
                };

            var hs = new HashSet<string>();

            foreach (string word in words)
            {
                var sb = new StringBuilder();
                for (int i = 0; i < word.Length; i++)
                {
                    sb.Append(arr[word[i] - 'a']);
                }
                hs.Add(sb.ToString());
            }

            return hs.Count;
        }
    }
}

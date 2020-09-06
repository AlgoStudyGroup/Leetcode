public class Solution {
    public bool RepeatedSubstringPattern(string s) {
        var len = s.Length;
        for (int i = len / 2; i >= 1; i--)
        {
            // Dividable
            if (len % i == 0)
            { 
                int m = len / i;
                var sub = s.Substring(0, i);
                int j;

                //Check sub is repeated in each round, until m rounds.
                for (j = 1; j < m; j++)
                {
                    if (!sub.Equals(s.Substring(j * i, i))) break;
                }

                //If sub is repeated m rounds, then it's a repeated substring
                if (j == m)
                    return true;
            }
        }
        return false;
    }

    public void Test()
    {
        var s = "abcdabcdabcd";
        var r = RepeatedSubstringPattern(s);
        Console.WriteLine(r);
    }
}
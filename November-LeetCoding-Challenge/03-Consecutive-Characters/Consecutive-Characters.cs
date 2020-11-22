using System;

namespace _1446_Consecutive_Characters
{
    public class Solution
    {
        public int MaxPower(string s)
        {
            int res = 1, cnt = 1;
            for (int i = 1; i < s.Length; i++)
            {
                if (s[i] == s[i - 1])
                {
                    cnt++;
                    res = Math.Max(res, cnt);
                }
                else
                {
                    cnt = 1;
                }
            }
            return res;
        }
    }
}

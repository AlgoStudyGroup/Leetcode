using System;

namespace _849_Maximize_Distance_to_Closest_Person
{
    public class Solution
    {
        public int MaxDistToClosest(int[] seats)
        {
            int res = 0, last = -1, len = seats.Length;
            for (int i = 0; i < len; i++)
            {
                if (seats[i] == 1)
                {
                    res = last < 0 ? i : Math.Max(res, (i - last) / 2);
                    last = i;
                }
            }
            res = Math.Max(res, len - last - 1);
            return res;
        }
    }
}
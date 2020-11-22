using System;

namespace _799_Champgane_Tower
{
    public class Solution
    {
        public double ChampagneTower(int poured, int query_row, int query_glass)
        {
            var res = new double[query_row + 2];
            res[0] = poured;

            for (int row = 1; row <= query_row; row++)
            {
                for (int i = row; i >= 0; i--)
                {
                    res[i] = Math.Max(0.0, (res[i] - 1) / 2);
                    res[i + 1] += res[i];
                }
            }

            return Math.Min(res[query_glass], 1.0);
        }
    }
}

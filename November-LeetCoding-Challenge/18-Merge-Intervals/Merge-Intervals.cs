using System;
using System.Collections.Generic;
using System.Linq;

namespace _56_Merge_Intervals
{
    public class Solution
    {
        public int[][] Merge(int[][] intervals)
        {
            if (intervals == null || intervals.Length < 2) return intervals;

            Array.Sort(intervals, (x, y) => new ArrayComparer().Compare(x, y));

            var prev = new int[2] { -1, -1 };
            var res = new List<int[]>();
            for (int i = 0; i < intervals.Length; i++)
            {
                var curr = intervals[i];
                if (prev[0] == -1 || curr[0] > prev[1])
                {
                    res.Add (curr);
                    prev = curr;
                }
                else if (curr[1] > prev[1])
                {
                    prev[1] = curr[1];
                }
            }
            return res.ToArray();
        }

        public class ArrayComparer : IComparer<int[]>
        {
            public int Compare(int[] x, int[] y)
            {
                return x[0] - y[0];
            }
        }
    }
}

using System.Collections.Generic;

namespace _593_Valid_Square
{
    public class Solution
    {
        public bool ValidSquare(int[] p1, int[] p2, int[] p3, int[] p4)
        {
            var arr =
                new int[] {
                    Cal(p1, p2),
                    Cal(p1, p3),
                    Cal(p1, p4),
                    Cal(p2, p3),
                    Cal(p2, p4),
                    Cal(p3, p4)
                };
            HashSet<int> hs = new HashSet<int>(arr);
            return !hs.Contains(0) && hs.Count == 2;
        }

        private int Cal(int[] a, int[] b)
        {
            return (a[0] - b[0]) * (a[0] - b[0]) +
            (a[1] - b[1]) * (a[1] - b[1]);
        }
    }
}

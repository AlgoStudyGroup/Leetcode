public class Solution {
    public int[] NumsSameConsecDiff(int N, int K) {
        var cur = new List<int>{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 2; i <= N; ++i) {
            var cur2 = new List<int>();
            foreach (int x in cur) {
                int y = x % 10;
                if (x > 0 && y + K < 10)
                    cur2.Add(x * 10 + y + K);
                if (x > 0 && K > 0 && y - K >= 0)
                    cur2.Add(x * 10 + y - K);
            }
            cur = cur2;
        }
        return cur.ToArray();
    }
}

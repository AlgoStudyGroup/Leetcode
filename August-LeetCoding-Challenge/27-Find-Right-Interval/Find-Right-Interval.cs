public class Solution {
    public int[] FindRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.Length];
        var map = new Dictionary<KeyValuePair<int, int>, int>();
        int N = intervals.Length;
        for(int i = 0; i < N; i++)
            map.Add(new KeyValuePair<int, int>(intervals[i][0], intervals[i][1]), i);
        Array.Sort(intervals, (a, b) => {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i = 0; i < N; i++){
            int index = -1;
            int b = intervals[i][1];
            for(int j = i + 1; j < N; j++){
                if(b <= intervals[j][0]){
                    index = map[new KeyValuePair<int, int>(intervals[j][0], intervals[j][1])];
                    break;
                }
            }
            ans[map[new KeyValuePair<int, int>(intervals[i][0], b)]] = index;
        }
        return ans;
    }
}

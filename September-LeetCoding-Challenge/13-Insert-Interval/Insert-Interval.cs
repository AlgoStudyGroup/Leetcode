public class Solution {
    public int[][] Insert(int[][] intervals, int[] newInterval) {
        var res = new List<int[]>();
        foreach(int[] i in intervals){
            if(newInterval == null || i[1] < newInterval[0]){
                res.Add(i);
            }
            else if(i[0] > newInterval[1]){
                res.Add(newInterval);
                res.Add(i);
                newInterval = null;
            }
            else{
                newInterval[0] = Math.Min(newInterval[0], i[0]);
                newInterval[1] = Math.Max(newInterval[1], i[1]);
            }
        }
        if(newInterval != null){
            res.Add(newInterval);
        }
        return res.ToArray();
    }
}

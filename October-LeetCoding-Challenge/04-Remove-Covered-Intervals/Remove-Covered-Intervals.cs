public class Solution {
    public int RemoveCoveredIntervals(int[][] intervals) {
        Array.Sort(intervals, (x, y) => x[0]==y[0] ? y[1]-x[1] : x[0]-y[0]);
        int count = 0;
        int curr = 0;
        foreach(int[] interval in intervals){
            if(curr < interval[1]){
                curr = interval[1];
                count++;
            }
        }
        return count;
    }
}
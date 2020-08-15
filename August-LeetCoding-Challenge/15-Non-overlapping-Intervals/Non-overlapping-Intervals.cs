public class Solution {
    public int EraseOverlapIntervals(int[][] intervals) {
        if(intervals.Length == 0) return 0;
        Array.Sort(intervals, new IntArrayComparer());
        var end = intervals[0][1];
        int count =1;
        for(int i=1; i<intervals.Length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.Length - count;
    }
}

public class IntArrayComparer : IComparer<int[]>{
     int IComparer<int[]>.Compare(int[] a, int[] b){
         return a[1] - b[1];
     }
}
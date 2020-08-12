public class Solution {
    //Formula solution
    public IList<int> GetRow(int rowIndex) {
        int[] arr = new int[rowIndex+1];
        arr[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++)
        {
            arr[i] = (int)(((long)arr[i - 1] * (rowIndex - i + 1)) / i);
        }

        return arr;
    }
}

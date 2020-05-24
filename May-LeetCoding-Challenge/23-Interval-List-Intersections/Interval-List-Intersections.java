class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int res[][];
        List<int[]> resList = new ArrayList();
        
        int i = 0, j = 0;
        int first = 0, second = 0;
        
        while (i < A.length && j < B.length) {
            first = Math.max(A[i][0], B[j][0]);
            second = Math.min(A[i][1], B[j][1]);
            if (first <= second) {
                resList.add(new int[]{first, second});
            }
            
            if (A[i][1] < B[j][1])
                i++;
            else 
                j++;
        }
        
        return resList.toArray(new int[resList.size()][]);
    }
}
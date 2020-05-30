/**
* Brute force approch, Runtime: 289 ms Memory Usage: 48.7 MB
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int countSquare = 0;
        for (int i = 1; i <= matrix.length && i <= matrix[0].length; i++) {
            for (int first = 0; first + i <= matrix.length; first++) {
                for (int second = 0; second + i <= matrix[0].length; second++) {
                    countSquare += isSquare(matrix, first, first+i, second, second+i) ? 1 : 0;
                }
            }
        }
        return countSquare;
    }
    
    private boolean isSquare(int[][] square, int xfrom, int xto, int yfrom, int yto) {
        for (int i = xfrom; i< xto; i++) {
            for (int j = yfrom; j < yto; j++) {
                if (square[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }    
}

/**
 * Dynamic programmingsolution
 * Runtime: 5 ms
 * Memory Usage: 49 MB
 * Time complexity: O(m*n)
 * Space complexity: O(1)
 */
class Solution2 {
    public int countSquares(int[][] matrix) {
        int length = matrix.length;
        if (length == 0)    return 0;
        
        int width = matrix[0].length;
        int res = 0;
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0)   continue;
                
                // border
                if (i == 0 || j == 0) {
                    res++;
                    continue;
                }
                
                // calculate min of different corner, and then plus himself
                int min = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                matrix[i][j] += min;

                res += matrix[i][j];
            }
        }
        
        return res;
    }
}
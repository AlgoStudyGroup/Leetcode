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
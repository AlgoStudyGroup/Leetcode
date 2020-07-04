class Solution {
    public int uniquePaths(int width, int height) {
        int[][] grid = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 || col == 0) {
                    grid[row][col] = 1;
                } else {
                    grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
                }
            }
        }
        return grid[height - 1][width - 1];
    }
}

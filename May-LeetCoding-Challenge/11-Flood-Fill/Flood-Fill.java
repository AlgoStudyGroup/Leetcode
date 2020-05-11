public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    // 0ms
    private void dfs(
            final int[][] image,
            final int x,
            final int y,
            final int target,
            final int newColor) {
        if (inBound(image, x, y) && image[x][y] == target) {
            image[x][y] = newColor;
            dfs(image, x - 1, y, target, newColor);
            dfs(image, x, y - 1, target, newColor);
            dfs(image, x + 1, y, target, newColor);
            dfs(image, x, y + 1, target, newColor);
        }
    }

    private boolean inBound(
            final int[][] image,
            final int x,
            final int y) {
        return x >= 0 && y >= 0 && x < image.length && y < image[0].length;
    }

    /*
    1ms
    public void dfs(int[][] image, int x, int y, int target, int newColor) {
        if (image[x][y] == target) {
            image[x][y] = newColor;
            if (x >= 1) {
                dfs(image, x - 1, y, target, newColor);
            }
            if (y >= 1) {
                dfs(image, x, y - 1, target, newColor);
            }
            if (x + 1 < image.length) {
                dfs(image, x + 1, y, target, newColor);
            }
            if (y + 1 < image[0].length) {
                dfs(image, x, y + 1, target, newColor);
            }
        }
    }
     */
}

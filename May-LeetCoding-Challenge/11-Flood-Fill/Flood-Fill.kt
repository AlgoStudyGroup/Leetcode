class FloodFillKotlin733 {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        if (newColor != image[sr][sc]) {
            dfs(image, image[sr][sc], sr, sc, newColor)
        }
        return image
    }

    // 320ms
    private fun dfs(
        image: Array<IntArray>,
        target: Int,
        x: Int,
        y: Int,
        newColor: Int
    ) {
        if (inBound(image, x, y) && image[x][y] == target) {
            image[x][y] = newColor
            // UP
            dfs(image, target, x - 1, y, newColor)
            // LEFT
            dfs(image, target, x, y - 1, newColor)
            // BOTTOM
            dfs(image, target, x + 1, y, newColor)
            // RIGHT
            dfs(image, target, x, y + 1, newColor)
        }
    }

    private fun inBound(image: Array<IntArray>, x: Int, y: Int): Boolean =
        x >= 0 && y >= 0 && x < image.size && y < image[0].size

    /*
    228 ms
    private fun dfs(
        image: Array<IntArray>,
        target: Int,
        x: Int,
        y: Int,
        newColor: Int
    ) {
        if (image[x][y] == target) {
            image[x][y] = newColor
            // UP
            if (x >= 1) {
                dfs(image, target, x - 1, y, newColor)
            }
            // LEFT
            if (y >= 1) {
                dfs(image, target, x, y - 1, newColor)
            }
            // BOTTOM
            if (x + 1 < image.size) {
                dfs(image, target, x + 1, y, newColor)
            }
            // RIGHT
            if (y + 1 < image[0].size) {
                dfs(image, target, x, y + 1, newColor)
            }
        }
    }
     */
}

// Runtime: 248 ms, faster than 93.23% of C# online submissions for Flood Fill.
// Memory Usage: 32.7 MB, less than 73.36% of C# online submissions for Flood Fill.
public class Solution
{
    public int[][] FloodFill(int[][] image, int sr, int sc, int newColor)
    {
        //sr is starting row position, sc is column position
        if (image[sr][sc] == newColor)
        {
            return image;
        }

        DfsFill(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    public void DfsFill(int[][] image, int row, int column, int oldColor, int newColor)
    {
        if (row < 0 || row >= image.Length || column < 0 || column >= image[row].Length || image[row][column] != oldColor)
        {
            return;
        }

        image[row][column] = newColor;

        DfsFill(image, row - 1, column, oldColor, newColor);
        DfsFill(image, row + 1, column, oldColor, newColor);
        DfsFill(image, row, column - 1, oldColor, newColor);
        DfsFill(image, row, column + 1, oldColor, newColor);
    }
}
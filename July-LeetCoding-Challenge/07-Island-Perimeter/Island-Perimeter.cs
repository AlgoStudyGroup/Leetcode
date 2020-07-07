public class Solution
{
    public int IslandPerimeter(int[][] grid)
    {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.Length; i++)
        {
            for (int j = 0; j < grid[0].Length; j++)
            {
                if (grid[i][j] == 1)
                {
                    islands++;
                    if (j < grid[0].Length - 1 && grid[i][j + 1] == 1) neighbours++;
                    if (i < grid.Length - 1 && grid[i + 1][j] == 1) neighbours++;
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}
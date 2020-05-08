//solution1 - intesting one line solution
public class Solution {
            public bool CheckStraightLine(int[][] c) => c.All(p => (c[0][0] - c[1][0]) * (c[0][1] - p[1]) == (c[0][1] - c[1][1]) * (c[0][0] - p[0]));
}



//solution 2 -mysolution
public class Solution {
    public bool CheckStraightLine(int[][] coordinates) {
        if (coordinates.Length <3)
        {
                return true;      
        }
        else{
         int crossx=coordinates[1][0]-coordinates[0][0];
         int crossy=coordinates[1][1]-coordinates[0][1];
         for (int i = 2 ; i < coordinates.Length; i++)
         {
             if (crossx*(coordinates[i][1]-coordinates[0][1]) != crossy*(coordinates[i][0]-coordinates[0][0]))
             {
                 return false;
             }
         }
            return true;
        }
    }
}


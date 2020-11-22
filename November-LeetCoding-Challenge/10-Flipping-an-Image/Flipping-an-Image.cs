namespace _832_Flipping_an_Image
{
    public class Solution
    {
            public int[][] FlipAndInvertImage(int[][] A) {
        if(A == null || A.Length == 0) return new int[0][];
        var levelLength = A[0].Length-1;
        int b =0;
        int e = levelLength;
        for(int i=0; i<=A.Length-1; i++){
            b = 0;
            e = levelLength;
            while(b < e){
                int temp = A[i][b];
                A[i][b] = A[i][e];
                A[i][e] = temp;
                b++;
                e--;
            }
            for(int j=0; j<=levelLength; j++){
                A[i][j] = 1 - A[i][j];
            }
        }
        return A;
    }
    }
}
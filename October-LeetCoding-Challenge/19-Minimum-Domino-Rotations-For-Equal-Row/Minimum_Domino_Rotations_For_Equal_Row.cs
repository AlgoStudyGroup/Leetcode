using System;

namespace _1007_Minimum_Domino_Rotations_For_Equal_Row
{
    public class Solution
    {
        public int MinDominoRotations(int[] A, int[] B)
        {
            int[] countA = new int[7], countB = new int[7], same = new int[7];
            int len = A.Length;

            //Count the occurence times of each number
            for (int i = 0; i < len; i++)
            {
                countA[A[i]]++;
                countB[B[i]]++;
                if (A[i] == B[i])
                {
                    same[A[i]]++;
                }
            }

            for (int i = 1; i < 7; i++)
            {
                if (countA[i] + countB[i] - same[i] == len)
                {
                    return len - Math.Max(countA[i], countB[i]);
                }
            }

            return -1;
        }
    }
}
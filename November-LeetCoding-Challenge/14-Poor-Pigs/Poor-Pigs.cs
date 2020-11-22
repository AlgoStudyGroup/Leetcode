using System;

namespace _458_Poor_Pigs
{
    public class Solution
    {
        public int PoorPigs(int buckets, int minutesToDie, int minutesToTest)
        {
            int pigs = 0;
            while (Math.Pow(minutesToTest / minutesToDie + 1, pigs) < buckets)
            {
                pigs += 1;
            }
            return pigs;
        }
    }
}

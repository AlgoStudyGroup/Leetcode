public class Solution {
    public int FindJudge(int N, int[][] trust) {
        int[] counter = new int[N+1];
        foreach ( int[] person in trust)
        {
            counter[person[0]]--;
            counter[person[1]]++;
        }
        for(int num=1; num<N+1; num++)
        {
            if(counter[num] == N-1)
            {
                 return num;
            }    
        }
return -1;
    }
}

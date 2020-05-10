class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] array = new int[N];
        int in, out;
        
        for(int i = 0; i < trust.length; i++) {
            in = trust[i][1];
            out = trust[i][0];
            array[in - 1] = array[in - 1] + 1;
            array[out - 1] = array[out - 1] - 1; 
        }
        
        // If a person only be trusted, and not trut anyone, then this person is judge.
        for(int j = 0; j < N; j++) {
            if(array[j] == N-1)
                return j+1;
        }
        
        return -1;
    }
}
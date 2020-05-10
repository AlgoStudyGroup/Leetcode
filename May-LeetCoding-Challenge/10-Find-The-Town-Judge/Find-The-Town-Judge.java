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

class Solution2 {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> possibleJudges = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            possibleJudges.add(i);
        }
        for (int[] pair : trust) {
            possibleJudges.remove(pair[0]);
        }
        if (possibleJudges.size() == 1) {
            Set<Integer> trusters = new HashSet<>();
            int currentJudge = possibleJudges.iterator().next();
            for (int[] pair: trust) {
                if (pair[1] == currentJudge) {
                    trusters.add(pair[0]);
                }
            }
            if (trusters.size() == N-1) {
                return currentJudge;
            }
        }
        return -1;
        
    }
}
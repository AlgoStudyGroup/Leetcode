class Solution {
    public int maxSubarraySumCircular(int[] A) {
        //Kadane's algorithm
        if(A == null || A.length == 0)  return 0;
        int maxTillHere = A[0];
        int maxInTotal = A[0];
        int minTillHere = A[0];
        int minInTotal = A[0];
        int sum = A[0];
        
        for(int i = 1; i < A.length; i++) {
            if (maxTillHere + A[i] > A[i]) {
                maxTillHere += A[i];
            } else {
                maxTillHere = A[i];
            }
            
            maxInTotal = Math.max(maxInTotal, maxTillHere);
            
            if (minTillHere + A[i] < A[i]) {
                minTillHere += A[i];
            } else {
                minTillHere = A[i];
            }
            
            minInTotal = Math.min(minInTotal, minTillHere);
            
            sum += A[i];
        }
        
        if (sum == minInTotal)  return maxInTotal;
        return Math.max(sum - minInTotal, maxInTotal);
        
    }
}
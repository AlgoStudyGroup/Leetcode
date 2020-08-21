public class Solution {
    public int[] SortArrayByParity(int[] A) {
        int  temp = 0;
        for(int i=0, j=0; j<A.Length; j++){
            if(A[j] % 2 == 0){
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
        }
        return A;
    }
}
public class Solution {
    public IList<int> PancakeSort(int[] A) {
        var res = new List<int>();
        int n = A.Length, largest = n;
        for (int i = 0; i < n; i++) {
            int index = Find(A, largest);
            Flip(A, index);
            Flip(A, largest - 1);
            res.Add(index + 1);
            res.Add(largest--);
        }
        return res;
    }
    
    private int Find(int[] A, int target){
        for(int i=0; i<A.Length; i++){
            if(A[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    private void Flip(int[] A, int idx){
        int i=0, j=idx;
        while(i<j){
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }
}


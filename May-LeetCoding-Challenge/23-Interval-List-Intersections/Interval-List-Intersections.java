class Solution {
    /* Solution 1
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<ArrayList<Integer>> inter = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i<A.length; ++i){
            for(int j=0; j<B.length; ++j){
                if(A[i][1] < B[j][0]) break;
                if(A[i][0] > B[j][1]) continue;
                if(A[i][0] <= B[j][0]){ 
                    ArrayList<Integer> e = new ArrayList<Integer>(); 
                    e.add(B[j][0]); 
                    e.add(Math.min(A[i][1], B[j][1]));
                    inter.add(e);
                }
                
                if(A[i][0] > B[j][0]){
                    ArrayList<Integer> e = new ArrayList<Integer>(); 
                    e.add(A[i][0]); 
                    e.add(Math.min(A[i][1], B[j][1]));
                    inter.add(e);
                }
                
            }
        }
        int result[][] = new int[inter.size()][2];
        for(int i=0; i<inter.size(); ++i){
            result[i][0] = inter.get(i).get(0);  
            result[i][1] = inter.get(i).get(1);  
        }
        
        return result;
        
    }
    */
    
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        int j=0;
        for(int i = 0; i<A.length; ++i){
            while(j<B.length){
                if(A[i][1] < B[j][0]) break;
                if(A[i][0] > B[j][1]){
                    ++j;
                    continue;
                }
                if(A[i][0] <= B[j][0]){
                    int set[] = new int[2];
                    set[0] = B[j][0]; 
                    set[1] = Math.min(A[i][1], B[j][1]);
                    result.add(set);
                    
                    if(A[i][1] < B[j][1])
                        break;
                }
                
                if(A[i][0] > B[j][0]){
                    int set[] = new int[2];
                    set[0] = A[i][0]; 
                    set[1] = Math.min(A[i][1], B[j][1]);
                    result.add(set);
                    
                    if(A[i][1] < B[j][1])
                        break;
                }
                ++j;
            }
            if(j >= B.length) break;
        }
        
        return result.toArray(new int[result.size()][2]);
        
    }
}
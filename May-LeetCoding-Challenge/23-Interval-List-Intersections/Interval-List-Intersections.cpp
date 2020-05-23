class Solution {
public:
    vector<vector<int>> ans;
    
    void does(int& i, vector<vector<int>>& A, int& j, vector<vector<int>>& B){
        if (B[j][0] <= A[i][1]) { 
            if (B[j][1] <= A[i][1]) {
                ans.push_back(vector<int>{B[j][0], B[j][1]});
                j++; 
            }
            else {
                ans.push_back(vector<int>{B[j][0], A[i][1]});
                i++;
            }       
        }
        else i++;
    }
    
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        int i = 0;
        int j = 0;
        ans.resize(0);
        while (i < A.size() and j < B.size()){
            if (A[i][0] <= B[j][0])  does(i, A, j, B);
            else does(j, B, i, A);
        }
        return ans;
    }
};
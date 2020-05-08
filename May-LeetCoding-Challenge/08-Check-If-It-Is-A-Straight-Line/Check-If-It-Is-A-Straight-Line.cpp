class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        int n = coordinates.size();
        if (n <= 2) return true;
        
        int ax = coordinates[1][0] - coordinates[0][0];
        int ay = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < n; i++){
            int bx = coordinates[i][0] - coordinates[i-1][0];
            int by = coordinates[i][1] - coordinates[i-1][1];
            if (ax * by - ay * bx != 0) return false;
        }
        return true;
    }
};
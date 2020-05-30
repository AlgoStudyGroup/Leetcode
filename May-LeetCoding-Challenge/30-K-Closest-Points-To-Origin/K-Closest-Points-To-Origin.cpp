class Solution {
public:
    struct T {
        int x, y, d;
        T(){}
        T(int x, int y): x(x), y(y){d = x * x + y * y;}
        bool operator < (const T& tmp) const {
            return d < tmp.d;
        }
    };
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        priority_queue<T> q;
        for (int i = 0; i < points.size(); i++){
            if (q.size() == K){
                if (q.top().d > points[i][0] * points[i][0] + points[i][1] * points[i][1]) {
                    q.pop();
                    q.push(T(points[i][0], points[i][1]));
                }
            }
            else 
                q.push(T(points[i][0], points[i][1]));
        }
                
        vector<vector<int>> ans;
        while(!q.empty()){
            vector<int> v = {q.top().x, q.top().y};
            ans.push_back(v);
            q.pop();
        }
        return ans;
    }
};
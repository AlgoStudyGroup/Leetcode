bool compare(vector<int>& p, vector<int>& q) {
        return (p[0] > q[0]) || (p[0] == q[0] && p[1] < q[1]);
}

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(), compare);
        vector<vector<int>> ans;
        for(int i = 0; i < people.size(); i++)
            ans.insert(ans.begin() + people[i][1], people[i]);
        return ans;
    }
};
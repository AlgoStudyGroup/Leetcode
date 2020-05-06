class Solution {
public:
    int countElements(vector<int>& arr) {
        int sum = 0;
        set<int> vis;
        for (auto t: arr)  vis.insert(t);
        for (auto t: arr) if (vis.find(t+1) != vis.end()) sum++;
        return sum;
    }
};
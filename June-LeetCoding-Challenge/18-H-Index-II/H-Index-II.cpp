class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (n - mid <= citations[mid]) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return n - left;
    }
};


// solution when the citations vector is not initially sorted.
class Solution2 {
public:
    int hIndex(vector<int>& citations) {
        make_heap(citations.begin(), citations.end(), greater<int>{});
        while(!citations.empty() && citations.front() < citations.size()){
            pop_heap(citations.begin(), citations.end(), greater<int>{});
            citations.pop_back();
        }
        
        return citations.size();
    }
};

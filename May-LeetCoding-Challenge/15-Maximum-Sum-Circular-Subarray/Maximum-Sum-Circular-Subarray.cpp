class Solution {
public:
    int maxSubarraySumCircular(const vector<int>& A) {
        int max_sum = A[0], min_sum = A[0];
        int sum1 = 0, sum2 = 0, tot = 0;

        for (auto &x: A) {
            sum1 += x; 
            sum2 += x;
            tot += x;
            if (sum1 > max_sum) max_sum = sum1;
            if (sum2 < min_sum) min_sum = sum2;
            if (sum1 < 0) sum1 = 0;
            if (sum2 > 0) sum2 = 0;
        }

        return (tot == min_sum)?max_sum:max(max_sum, tot - min_sum);
    }
};
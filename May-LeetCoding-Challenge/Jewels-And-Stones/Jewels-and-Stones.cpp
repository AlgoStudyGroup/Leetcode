class Solution {
public:
    int numJewelsInStones(string J, string S) {
        set<char> jewel(J.begin(), J.end());
        int cnt = 0;
        for (auto &c: S)
            if (jewel.find(c) != jewel.end())
                cnt ++;
        return cnt;
    }
};
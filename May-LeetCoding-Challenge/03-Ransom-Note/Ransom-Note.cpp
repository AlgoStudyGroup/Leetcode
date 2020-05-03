class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> nums(26, 0);
        for (auto &c: magazine) nums[c - 'a']++;
        for (auto &c: ransomNote) 
            if (nums[c - 'a']-- <= 0) return false;
        return true;
    }
};
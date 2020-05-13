class Solution {
public:
    string removeKdigits(string num, int k) {
        string ans;
        for (auto& c : num){
            while (k and ans.length() and c < ans[ans.length() - 1]) {
                ans.pop_back();
                k--;
            }
            if (ans.length() == 0 and c == '0') continue;
            ans += c;
        }
         
        while (k-- and ans.length()) ans.pop_back();
        
        return ans.length()?ans:"0";
        
    }
};
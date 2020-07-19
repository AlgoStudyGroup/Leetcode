class Solution {
public:
    string addBinary(string a, string b) {
        string ans = (a.length() > b.length())?a:b;
        int sum = 0;
        for (int i = 0; i < ans.length(); i++){
            if (i < a.length()) sum += (a[a.length() - i - 1] == '1')?1:0;
            if (i < b.length()) sum += (b[b.length() - i - 1] == '1')?1:0;
            ans[ans.length() - i - 1] = (sum & 1) + '0';
            sum >>= 1;
        }
        if (sum == 1) ans = "1" + ans;
        return ans;
    }
};
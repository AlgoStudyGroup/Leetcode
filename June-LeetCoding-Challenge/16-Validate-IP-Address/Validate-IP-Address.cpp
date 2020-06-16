class Solution {
public:
    void split(string str, char delim, vector<string>& ans) {
        int current, previous = 0;
        current = str.find(delim);
        ans.resize(0);
        while (current != std::string::npos) {
            ans.push_back(str.substr(previous, current - previous));
            previous = current + 1;
            current = str.find(delim, previous);
        }
        ans.push_back(str.substr(previous, current - previous));
    }
    
    bool is_IP4(vector<string>& s){
        if (s.size() != 4) return false;
        for (int i = 0; i < 4; i++){
            if (s[i].size() == 0 or s[i].size() > 3 or (s[i][0] == '0' and s[i].size() > 1)) return false;
            for (auto& c: s[i]) if (!isdigit(c)) return false;
            int tmp = stoi(s[i]);
            if (tmp < 0 or tmp > 255) return false;
        }
        return true;
    }
    
    bool is_IP6(vector<string>& s){
        if (s.size() != 8) return false;
        for (int i = 0; i < 8; i++){
            if (s[i].size() == 0 or s[i].size() > 4) return false;
            for (auto& c: s[i]) { 
                c = toupper(c);
                if (isdigit(c)) continue;
                if (c >= 'A' and c <= 'F') continue;
                return false;
            }
        }
        return true;
    }
    
    string validIPAddress(string IP) {
        vector<string> s;
        split(IP, '.', s);
        if (is_IP4(s)) return "IPv4";
        split(IP, ':', s);
        if (is_IP6(s)) return "IPv6";
        return "Neither";
    }
};


class Solution2 {
public:
    string validIPAddress(string IP) {
        if (IP.find('.') != string::npos) {
            regex ipv4_regex("((2[0-4]\\d|25[0-5]|0|[1-9]\\d?|1\\d\\d)\\.){3}(2[0-4]\\d|25[0-5]|0|[1-9]\\d?|1\\d\\d)");
            // 2[0-4]\\d    200~249
            // 25[0-5]      250~255
            // 0            0
            // [1-9]\\d?    1~99
            // 1\\d\\d      100~199
            if (regex_match(IP, ipv4_regex))
                return "IPv4";
        }
        else if (IP.find(':') != string::npos) {
            regex ipv6_regex("([\\da-fA-F]{1,4}:){7}([\\da-fA-F]{1,4})");
            //  [\\da-fA-F]{1,4}        0000~FFFF
            if (regex_match(IP, ipv6_regex))
                return "IPv6";
        }

        return "Neither";
    }
};

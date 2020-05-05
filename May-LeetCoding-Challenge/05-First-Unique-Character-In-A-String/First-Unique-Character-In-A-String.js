/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var firstUniqChar = function(s) {
    var stats = new Array(26);
    for(var i = 0;i<26;i++){
        stats[i]=0;
    }
    for(var ch of s){
        let tmp = ch.charCodeAt()-97;
        stats[tmp]++;
    }
    var res = -1;
    for(var i = 0;i<s.length;i++){
        let tmp = s[i].charCodeAt()-97;
        if((stats[tmp]^1)==0){
            res = i;
            break;
        }
    }
    return res;
};

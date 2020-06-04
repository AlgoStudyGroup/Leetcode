/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {
    var i = 0;
    var j = s.length-1;
    while(i<j){
        let tmp = s[i];
        s[i]=s[j];
        s[j]=tmp;
        i++;
        j--;
    }
    return s;
};

/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    var flag = true;
    var stats = new Array(26);
    for(let i = 0;i<26;i++){
        stats[i]=0;
    }
    for(var ch of magazine){
        let index = ch.charCodeAt()-97;//given that 'a'.charCodeAt()=97
        stats[index]++;
    }
    for(var ch of ransomNote){
        let index = ch.charCodeAt()-97;
        stats[index]--;
    }
    for(var int of stats){
        if(int<0){return false;}
    }
    return true;
};

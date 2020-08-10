/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
    var somme = 0;
    var digit = 1;
    for(let i = s.length - 1;i >= 0;i--){
        somme += (s.charCodeAt(i) - 64) * Math.pow(26,digit-1);
        digit++;
    }
    return somme;
};

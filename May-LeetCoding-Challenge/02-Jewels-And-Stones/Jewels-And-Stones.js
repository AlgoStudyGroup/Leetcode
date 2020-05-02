/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    var S_ensemble = new Set(J);//Hash Table O(1)
    var res = 0;
    for(var lettre of S){
        if(S_ensemble.has(lettre)){
            res++;
        }
    }
    return res;
};

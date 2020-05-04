/**
 * @param {number} num
 * @return {number}
 */
// Solution 1: 
var findComplement = function(num) {
    var i = 0;
    var count = 0;
    while (num>0){
        if((num&1)==0){
            i += (1<<count)
        }
        count++;
        num = (num>>1);
    }
    return i;
};

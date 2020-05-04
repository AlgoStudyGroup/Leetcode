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

// Solution 2:
var findComplement = function(num) {
    var i = 1;
    while (i<num){
        i = (i<<1)+1;
        console.log(i);
    }
    return i^num;
};

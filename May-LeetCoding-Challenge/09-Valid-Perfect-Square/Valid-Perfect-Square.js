/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    if(num==1){return true;}
    var i = 1;
    var j = parseInt(num/2);
    while(i<j){
        let mid = parseInt((i+j)/2);
        let square = mid*mid;
        if(i*i==num || j*j==num||square==num){
            return true;
        }
        else if(square<num){
            i = mid+1;
        }
        else{
            j = mid-1;
        }
    }
    return false;
};

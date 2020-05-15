/**
 * @param {number[]} A
 * @return {number}
 */
var maxSubarraySumCircular = function(A) {
    if(A.length==1){
        return Math.max(A[0],A[0]*2);
    }
    var somme = 0;
    for(let i = 0;i<A.length;i++){
        somme+=A[i];
    }
    var max = maxNotCircular(A);  
    var B = A.slice(1,A.length);
    for(let i = 0;i<B.length;i++){
        B[i]=0-B[i];
    }
    var min = 0-maxNotCircular(B);
    return Math.max(max,somme-min);
    
};

var maxNotCircular = function(A){
    if(A.length==1){return A[0];}
    var DP = new Array(A.length);
    DP[0]=A[0];
    var res = A[0];
    for(let i = 1;i<A.length;i++){
        if(DP[i-1]<0){
            DP[i] = A[i];
        }
        else{
            DP[i]=A[i]+DP[i-1];
        }
        res = Math.max(DP[i],res);
    }
    return res;    
};

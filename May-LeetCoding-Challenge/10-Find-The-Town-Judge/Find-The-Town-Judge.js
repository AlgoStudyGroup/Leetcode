/**
 * @param {number} N
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(N, trust) {
    var trusting = new Array(N);
    var trusted = new Array(N);
    for(let i = 0;i<N;i++){
        trusting[i]=0;
        trusted[i]=0;
    }
    for(let arr of trust){
        trusting[arr[0]-1]++;
        trusted[arr[1]-1]++;
    }
    for(let i = 0;i<N;i++){
        if(trusting[i]==0 && trusted[i]==(N-1)){
            return i+1;
        }
    }
    return -1;
};

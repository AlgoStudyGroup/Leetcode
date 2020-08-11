var hIndex = function(citations) {
    if(citations.length==0){return 0;}
    citations.sort(function(a,b){
        return b-a;
    });
    var res = 0;
    if(citations[0] < 1){return 0;}
    for(let i=0;i<citations.length;i++){
        let a = i+1;
        if(a==citations[i]){return a;}
        if(a > citations[i]){
            let reste = citations.length-a+1;
            res = citations[i];
            while(citations.length-res > reste){res++;}
            return res;
        }
    }
    return citations.length;
};

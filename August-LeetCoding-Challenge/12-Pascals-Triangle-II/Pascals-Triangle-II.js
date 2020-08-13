var getRow = function(rowIndex) {
    var res = new Array();
    res.push(1);
    if(rowIndex==0){return res;}
    res.push(1);
    if(rowIndex==1){return res;}
    var k = 2;
    return recursion(k,rowIndex,res);
};

var recursion = function(k,rowIndex,res){
    if(k-1==rowIndex){return res;}
    var result = new Array();
    result.push(1);
    for(let i = 1;i < res.length;i++){
        result.push(res[i]+res[i-1]);
    }
    result.push(1);
    //console.log(k+" "+result);
    return recursion(k+1,rowIndex,result);
}

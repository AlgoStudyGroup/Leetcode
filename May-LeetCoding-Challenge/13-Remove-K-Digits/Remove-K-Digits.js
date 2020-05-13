var removeKdigits = function(num, k) {
    if(k==num.length){return "0";}
    num = num.split("");
    var monotone_stack = new Array();
    monotone_stack.push(num[0]);
    var i = 1;
    while(k>0 && i<num.length){
        let peek = monotone_stack[monotone_stack.length-1];
        if(num[i]<peek){
            while(num[i]<peek && k>0){
                monotone_stack.pop(); 
                k--;
                peek = monotone_stack[monotone_stack.length-1];
            }
            monotone_stack.push(num[i]);
        }
        else{
            monotone_stack.push(num[i]);
        }
        i++;
    }
    while(k>0){
        monotone_stack.pop();
        k--;
        //console.log(monotone_stack+" --- "+k);
    }
    while(i<num.length){
        monotone_stack.push(num[i]);
        i++;        
    }
    while(monotone_stack[0]=="0"){
        monotone_stack.shift();
    }
    var res = monotone_stack.join("");
    if(res==""){return "0";}
    return res;
};

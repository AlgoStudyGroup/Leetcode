/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    coins.sort(function(a,b){return a-b;})
    if(amount>0 && coins.length==0){
        return 0;
    }
    var dp = new Array(amount+1);
    dp.fill(0);
    dp[0] = 1;
    for(let coin of coins){
        for(let i = 1;i<=amount;i++){
            if(i>=coin){
                dp[i]+=dp[i-coin];
            }
        }
    }
    return dp[amount];
};

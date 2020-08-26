public class Solution {
    //Solution 1
    public IList<string> FizzBuzz(int n) {
        int i=1;
        var res = new List<string>();
        while(i<=n){
            if(i%15 == 0){
                res.Add("FizzBuzz");
            }else if(i%3==0){
                res.Add("Fizz");
            }else if(i%5 == 0){
                res.Add("Buzz");
            }else{
                res.Add(i.ToString());
            }
            i++;
        }
        return res;
    }

    //Solution 2
    public IList<string> FizzBuzz(int n) {
        var res = new List<string>();
        int fizz = 0, buzz = 0;
        for(int i=1; i<=n; i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz == 5){
                res.Add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz == 3){
                res.Add("Fizz");
                fizz=0;
            }else if(buzz == 5){
                res.Add("Buzz");
                buzz=0;
            }else{
                res.Add(i.ToString());
            }
        }
        return res;
    }
}
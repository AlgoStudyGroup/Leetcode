public class Solution {
    public string GetHint(string secret, string guess) {
        var bulls = 0;
        var cows = 0;
        int[] secretarr = new int[10];
		int[] guessarr = new int[10];
        for(int i=0; i<secret.Length; i++){
            if(secret[i] == guess[i]){
                bulls++;
            }else {
                ++secretarr[secret[i] - '0'];
				++guessarr[guess[i] - '0'];
            }
        }
        for (int i = 0; i < 10; ++i) {
			cows += Math.Min(secretarr[i], guessarr[i]);
		}
        return bulls + "A" + cows + "B";
    }
}

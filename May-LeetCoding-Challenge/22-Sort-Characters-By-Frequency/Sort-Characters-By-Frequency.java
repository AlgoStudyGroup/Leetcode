class Solution {
    public String frequencySort(String s) {
        StringBuilder S = new StringBuilder();
        int table[] = new int[128];
        for(int i=0; i<s.length(); ++i){
            ++table[s.charAt(i)];
        }
        
        int max = 0;
        int temp = table[max];
        do {
            max = 0;
            temp = table[max];
            for(int j=0; j<128; ++j){
                if(table[j]> temp){
                    max = j;
                    temp = table[max];
                }
            }
            for(int k=temp; k>0; --k){
                S.append((char)max);
            }
            table[max] = 0;
        } while(temp != 0);
        return S.toString();
    }
}
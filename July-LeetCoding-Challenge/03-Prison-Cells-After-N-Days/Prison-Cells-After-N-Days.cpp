class Solution {
public:
    vector<int> prisonAfterNDays(vector<int>& cells, int N) {
        // vector<vector<int>> memo;
        //memo.push_back(cells);
        N=(N%14==0)?14:N%14;
        for(int i=1; i<=N; ++i){
            vector<int> cpy = cells;
            for(int j=0; j<8; ++j){
                if(j-1>=0&&j+1<8&&cells[j-1]==cells[j+1]) cpy[j]=1;
                else cpy[j]=0;
            }
            /*
            for(int j=0; j<memo.size(); ++j)
                if(memo[j] == cpy)
                    cout<<"day "<< i<<" equals to day "<<j<<endl;
            memo.push_back(cpy);
            */
            swap(cells, cpy);
        }
        return cells;
    }
};

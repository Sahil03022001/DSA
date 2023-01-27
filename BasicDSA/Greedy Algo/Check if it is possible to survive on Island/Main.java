class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        if(M > N)return -1;
        
        int foodRequired = S * M;
        int foodGot = N;
        int ans = 0;
        
        if(foodRequired % foodGot == 0){
            ans = foodRequired / foodGot;
        }
        else{
            ans = foodRequired / foodGot + 1;
        }
        
        if(ans <= (S - S/7)){
            return ans;
        }
        
        return -1;
    }
}
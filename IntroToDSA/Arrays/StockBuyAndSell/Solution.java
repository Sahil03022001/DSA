package IntroToDSA.Arrays.StockBuyAndSell;

public class Solution {
    public int maxProfit(int[] prices) {
        
        int minSoFar = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minSoFar){
                minSoFar = prices[i];
            }else{
                ans = Math.max(ans, prices[i] - minSoFar);
            }
        }
        return ans;
    }
}

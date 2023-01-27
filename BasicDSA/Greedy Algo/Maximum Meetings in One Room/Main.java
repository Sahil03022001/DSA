class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        // code here
        
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++){
            dp[i][0] = start[i];
            dp[i][1] = end[i];
            dp[i][2] = i + 1;
        }
        
        Arrays.sort(dp, (a, b) -> a[1] - b[1]);
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(dp[0][2]);
        int endTime = dp[0][1];
        for(int i = 1; i < n; i++){
            if(dp[i][0] > endTime){
                ans.add(dp[i][2]);
                endTime = dp[i][1];
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}
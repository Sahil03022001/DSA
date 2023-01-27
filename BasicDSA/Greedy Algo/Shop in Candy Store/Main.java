class Solution{
    static ArrayList<Integer> candyStore(int candies[], int n, int k){
        // code here
        
        Arrays.sort(candies);
        
        int i = 0, j = n - 1;
        int minAns = 0;
        while(i <= j){
            minAns += candies[i++];
            j -= k;
        }
        
        i = 0;
        j = n - 1;
        int maxAns = 0;
        while(i <= j){
            maxAns += candies[j--];
            i += k;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(minAns);
        ans.add(maxAns);
        return ans;
    }
}
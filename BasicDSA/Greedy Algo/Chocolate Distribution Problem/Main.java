class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        long ans = Integer.MAX_VALUE;
        Collections.sort(a);
        
        int i = 0, j = m - 1;
        while(j < n){
            ans = Math.min(ans, a.get(j) - a.get(i));
            i++;
            j++;
        }
        
        return ans;
    }
}
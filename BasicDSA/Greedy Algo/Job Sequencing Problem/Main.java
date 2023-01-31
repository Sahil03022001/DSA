class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        Set<Integer> set = new HashSet<>();
        int maxProfit = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            int currDead = arr[i].deadline;
            while(set.contains(currDead)){
                currDead--;
            }
            
            if(currDead > 0){
                set.add(currDead);
                maxProfit += arr[i].profit;
                count++;
            }
        }
        
        return new int[] {count, maxProfit};
    }
}
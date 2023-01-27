class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long val : arr)
            pq.add(val);
            
        long ans = 0;
        while(pq.size() > 1){
            long sum = pq.poll() + pq.poll();
            ans += sum;
            pq.add(sum);
        }
        
        return ans;
    }
}
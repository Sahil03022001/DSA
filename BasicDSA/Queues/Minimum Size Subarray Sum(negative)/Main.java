class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n = nums.length;
        
        long[] preSum = new long[n + 1];
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + (long)nums[i];
        }
        
        Deque<Integer> dq = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < preSum.length; i++){
            
            while(!dq.isEmpty() && preSum[i] <= preSum[dq.getLast()])
                dq.removeLast();
            
            while(!dq.isEmpty() && preSum[i] >= preSum[dq.getFirst()] + k)
                ans = Math.min(ans, i - dq.removeFirst());
            
            dq.add(i);
        }
        
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
}
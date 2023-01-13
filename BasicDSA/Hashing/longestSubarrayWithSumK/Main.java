class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        
        for(int i = 0; i < N; i++){
            
            sum += A[i];
            
            if(sum == K)
                ans = i + 1;
            
            if(map.containsKey(sum - K))
                ans = Math.max(ans, i - map.get(sum - K));
                
            if(!map.containsKey(sum))
                map.put(sum, i);
            
        }
        
        return ans;
    }
    
    
}
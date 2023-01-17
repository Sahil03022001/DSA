class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        
        for(int i = 0; i < n; i++){
            
            if(rains[i] == 0){
                zeros.add(i);
            }
            else{
                if(map.containsKey(rains[i])){
                   Integer next = zeros.higher(map.get(rains[i]));
                    if(next == null){
                        return new int[0];
                    }
                    ans[next] = rains[i];
                    zeros.remove(next);
                }
                ans[i] = -1;
                map.put(rains[i], i);
            }
        }
        return ans;
    }
}
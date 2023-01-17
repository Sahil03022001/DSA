class Solution {
    public int numRabbits(int[] answers) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : answers){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int ans = 0;
        for(int key : map.keySet()){
            
            int gs = key + 1;
            int r = map.get(key);
            
            int ng = r / gs;
            if(r % gs > 0){
                ng++;
            }
            
            ans += gs * ng;
        }
        return ans;
    }
}
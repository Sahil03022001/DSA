class Solution {
    public int longestSubstring(String s, int k) {
        
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        
        int[] cntMap = new int[26];
        int maxUnique = set.size();
        int res = 0;
        for(int curUnique = 1; curUnique <= maxUnique; curUnique++){
            
            Arrays.fill(cntMap, 0);
            int inc = 0, exc = 0, cntAtLeastK = 0, unique = 0, idx = 0;
            
            while(inc < s.length()){
                
                if(unique <= curUnique){
                    idx = s.charAt(inc) - 'a';
                    if(cntMap[idx] == 0) unique++;
                    cntMap[idx]++;
                    if(cntMap[idx] == k) cntAtLeastK++;
                    inc++;
                }
                else{
                    idx = s.charAt(exc) - 'a';
                    if(cntMap[idx] == k) cntAtLeastK--;
                    cntMap[idx]--;
                    if(cntMap[idx] == 0) unique--;
                    exc++;
                }
                
                if(unique == curUnique && unique == cntAtLeastK){
                    res = Math.max(res, inc - exc);
                }
            }
        }
        
        return res;
    }
}
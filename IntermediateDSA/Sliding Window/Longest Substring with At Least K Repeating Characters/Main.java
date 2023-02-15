//recursive approach
class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k, 0, s.length());
    }

    int helper(String s, int k, int start, int end){

        if(end < k){
            return 0;
        }

        int[] sf = new int[256];
        for(int i = start; i < end; i++){
            sf[s.charAt(i)]++;
        }

        for(int i = start; i < end; i++){
            if(sf[s.charAt(i)] < k){
                int j = i + 1;
                while(j < end && sf[s.charAt(j)] < k) j++;
                int leftLen = helper(s, k, start, i);
                int rightLen = helper(s, k, j, end);
                return Math.max(leftLen, rightLen);
            }
        }

        return end - start;
    }
}

//sliding window approach
class Solution {

    public int longestSubstring(String s, int k) {
        
        boolean[] sf = new boolean[256];
        int maxUni = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!sf[ch]){
                sf[ch] = true;
                maxUni++;
            }
        }

        int n = s.length();
        int res = 0;

        for(int uniAllowed = 1; uniAllowed <= maxUni; uniAllowed++){

            int sp = 0, ep = 0;
            int currUni = 0;
            int cntValid = 0;
            Map<Character, Integer> currWin = new HashMap<>();

            while(ep < n){
                
                if(currUni <= uniAllowed){
                    char ch = s.charAt(ep);
                    if(!currWin.containsKey(ch)) currUni++;
                    currWin.put(ch, currWin.getOrDefault(ch, 0) + 1);
                    if(currWin.get(ch) == k) cntValid++;
                    ep++;
                }
                else{
                    char ch = s.charAt(sp);
                    if(currWin.get(ch) == k) cntValid--;
                    currWin.put(ch, currWin.get(ch) - 1);
                    if(currWin.get(ch) == 0){
                        currWin.remove(ch);
                        currUni--;
                    }
                    sp++;
                }

                if(cntValid == currUni && currUni == uniAllowed){
                    res = Math.max(res, ep - sp);
                }
            }
        }

        return res;
    }
}
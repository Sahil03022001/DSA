//Binary search + sliding window
class Solution {
    public int characterReplacement(String s, int k) {

        int lo = 1;
        int hi = s.length();
        int res = 0;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(windowExists(s, k, mid)){
                res = mid;
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return res;
    }

    private boolean windowExists(String s, int k, int winLen){

        Map<Character, Integer> map = new HashMap<>();
        int sp = 0;
        int ep = 0;
        int n = s.length();
        int maxFreq = 0;
        while(ep < n){
            char ch = s.charAt(ep);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if(ep - sp + 1 == winLen){
                if(winLen - maxFreq <= k) return true;
                else{
                    char toDel = s.charAt(sp);
                    map.put(toDel, map.get(toDel) - 1);
                    sp++;
                }
            }
            ep++;
        }
        return false;
    }
}

//sliding window
class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int sp = 0, ep = 0;
        int maxFreq = 0;
        int res = 0;
        while(ep < n){
            char ch = s.charAt(ep);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while((ep - sp + 1 - maxFreq) > k){
                char toDel = s.charAt(sp);
                map.put(toDel, map.get(toDel) - 1);
                sp++;
            }

            res = Math.max(res, ep - sp + 1);
            ep++;
        }

        return res;
    }
}
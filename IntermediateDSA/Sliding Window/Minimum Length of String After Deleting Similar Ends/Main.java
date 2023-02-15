class Solution {
    public int minimumLength(String s) {
        
        int sp = 0;
        int ep = s.length() - 1;
        while(sp < ep){
            char first = s.charAt(sp);
            char second = s.charAt(ep);

            if(first != second){
                return ep - sp + 1;
            }
            else{
                sp++;ep--;
                if(sp == ep) return 1;
                while(sp < ep && s.charAt(sp) == s.charAt(sp - 1)) sp++;
                if(sp == ep) return 0;
                while(sp < ep && s.charAt(ep) == s.charAt(ep + 1)) ep--;
            }
        }

        
        return ep - sp + 1;
    }
}
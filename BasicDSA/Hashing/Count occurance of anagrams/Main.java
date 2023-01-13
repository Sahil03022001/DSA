class Solution {

    int search(String pat, String txt) {
        // code here
        
        char[] cnt_pat = new char[256];
        char[] cnt_txt = new char[256];
        
        for(int i = 0; i < pat.length(); i++){
            cnt_pat[pat.charAt(i)]++;
        }
        
        int k = pat.length();
        int j = 0;
        int cnt = 0;
        
        for(int i = 0; i < txt.length(); i++){
            
            char ch = txt.charAt(i);
            cnt_txt[ch]++;
            
            if(i - j + 1 == k){
                if(Arrays.equals(cnt_pat, cnt_txt))cnt++;
                cnt_txt[txt.charAt(j)]--;
                j++;
            }
        }
        
        return cnt;
    }
}
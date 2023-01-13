class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            
            //generate freq array
            int[] freq = new int[26];
            for(int j = 0; j < str.length(); j++){
                freq[str.charAt(j) - 'a']++;
            }
            
            //generate code
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26; j++){
                if(freq[j] > 0){
                    sb.append('a' + j);
                    sb.append(freq[j]);
                }
            }
            
            //put in hashmap
            String code = sb.toString();
            if(!map.containsKey(code)){
                ArrayList<String> list = new ArrayList<>();
                map.put(code, list);
            }
            
            ArrayList<String> temp = map.get(code);
            temp.add(str);
            map.put(code, temp);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ArrayList<String> temp = map.get(key);
            ans.add(temp);
        }
        return ans;
    }
}
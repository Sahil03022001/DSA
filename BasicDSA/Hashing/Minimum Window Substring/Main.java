import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
		// write code here
		Map<Character, Integer> freq = new HashMap<>();
		for(char c : t.toCharArray()){
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		String ans = "";
		int cnt = 0;
		int dcnt = t.length();
		int inc = -1, exc = -1;
		Map<Character, Integer> map = new HashMap<>();
		while(true){

			boolean f1 = false;
			boolean f2 = false;
			
			//include the character
			while(inc < s.length() - 1 && cnt < dcnt){
				
				inc++;
				char ch = s.charAt(inc);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if(map.get(ch) <= freq.getOrDefault(ch, 0)){
					cnt++;
				}

				f1 = true;
			}

			//exclude the character
			while(exc < inc && cnt == dcnt){
				
				String temp = s.substring(exc + 1, inc + 1);
				if(ans.length() == 0 || ans.length() > temp.length()){
					ans = temp;
				}

				exc++;
				char ch = s.charAt(exc);
				map.put(ch, map.get(ch) - 1);

				if(freq.containsKey(ch) && freq.get(ch) > map.get(ch)){
					cnt--;
				}

				if(map.get(ch) == 0){
					map.remove(ch);
				}

				f2 = true;
			}

			if(!f1 && !f2)break;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}
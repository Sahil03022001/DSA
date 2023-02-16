import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int n = str.length();
		Map<Character, Integer> map = new HashMap<>();
		int sp = 0, ep = 0;
		int res = 0;
		while(ep < n){
			char ch = str.charAt(ep);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			while(sp<ep && map.size() > k){
				char toDel = str.charAt(sp);
				map.put(toDel, map.get(toDel) - 1);
				if(map.get(toDel) == 0){
					map.remove(toDel);
				}
				sp++;
			}

			res = Math.max(res, ep-sp+1);
			ep++;
		}
		return res;
	}

}

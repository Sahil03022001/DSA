import java.util.*;

class Solution {

	private boolean excessWords(Map<String, Integer> mm, Map<String, Integer> cm){
		for(String word : cm.keySet()){
			if(!mm.containsKey(word)) return true;
			if(cm.get(word) > mm.get(word)) return true;
		}
		return false;
	}
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
		Map<String, Integer> mainMap = new HashMap<>();
		for(String word : words){
			mainMap.put(word, mainMap.getOrDefault(word, 0) + 1);
		}

		int n = s.length();
		int wordLen = words[0].length();
		int totalWords = words.length;
		int answerSize = wordLen * totalWords;
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < wordLen; i++){

			int sp = i, ep = i;
			Map<String, Integer> currWin = new HashMap<>();
			while(ep + wordLen <= n){
				String word = s.substring(ep, ep + wordLen);
				currWin.put(word, currWin.getOrDefault(word, 0) + 1);
				ep += wordLen;

				while(sp < ep && excessWords(mainMap, currWin)){
					String toDel = s.substring(sp, sp + wordLen);
					currWin.put(toDel, currWin.get(toDel) - 1);
					if(currWin.get(toDel) == 0){
						currWin.remove(toDel);
					}
					sp += wordLen;
				}

				if(answerSize == ep - sp){
					res.add(sp);
				}
			}
		}

		return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}

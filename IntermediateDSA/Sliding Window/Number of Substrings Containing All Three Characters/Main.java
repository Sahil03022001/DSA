import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	   public static void main(String args[]) {
		  
		   Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.numberOfSubstrings(s));
	    }
}
class Solution {
    public static int numberOfSubstrings(String s) {
        
        int n = s.length();
        int sp = 0, ep = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(ep < n){

            char ch = s.charAt(ep);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() == 3){
                res += n - ep;
                char toDel = s.charAt(sp);
                map.put(toDel, map.get(toDel) - 1);
                if(map.get(toDel) == 0){
                    map.remove(toDel);
                }
                sp++;
            }

            ep++;
        }

        return res;
    }
}
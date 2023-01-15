import java.util.*;

public class Main {

    public static long DistinctCharacterSubstring(String s){
        //write code here

		int n = s.length();
		long ans = 0;
		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(i < n){
			char ch = s.charAt(i);
			if(map.containsKey(ch)){
				j = Math.max(j, map.get(ch) + 1);
			}
			map.put(ch, i);
			ans += (i - j + 1);
			i++;
		}
		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}

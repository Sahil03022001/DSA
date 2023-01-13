import java.util.*;

public class Main {

    public static String DistinctWindow(String s){
        //write code here
		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()){
			set.add(c);
		}

		Map<Character, Integer> map = new HashMap<>();
		String ans = "";
		int inc = -1, exc = -1;
		while(true){

			boolean flag1 = false;
			boolean flag2 = false;

			//including the character
			while(inc < s.length() - 1 && map.size() < set.size()){

				inc++;
				char ch = s.charAt(inc);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				flag1 = true;
			}

			//excluding the character
			while(exc < inc && map.size() == set.size()){

				String temp = s.substring(exc + 1, inc + 1);
				if(ans.length() == 0 || ans.length() > temp.length()){
					ans = temp;
				}
				
				exc++;
				char ch = s.charAt(exc);
				map.put(ch, map.get(ch) - 1);

				if(map.get(ch) == 0){
					map.remove(ch);
				}

				flag2 = true;
			}

			if(!flag1 && !flag2)break;
		}

		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}
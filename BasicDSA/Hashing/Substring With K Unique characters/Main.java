import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k,String s){
        //write code here
		Map<Character, Integer> map = new HashMap<>();
		int ans = -1, inc = -1, exc = -1;
		while(true){

			boolean f1 = false;
			boolean f2 = false;

			//including the character
			while(inc < s.length() - 1 && map.size() <= k){

				inc++;
				char ch = s.charAt(inc);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if(map.size() == k)
					ans = Math.max(ans, inc - exc);

				f1 = true;
			}

			//excluding the character
			while(exc < inc && map.size() > k){

				exc++;
				char ch = s.charAt(exc);
				map.put(ch, map.get(ch) - 1);

				if(map.get(ch) == 0){
					map.remove(ch);
				}

				f2 = true;
			}

			if(!f1 && !f2)break;
		}

		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}
import java.util.*;

class Accio {
    public int longestSubsequence(int[] nums) {
       //Your code goes here
		Map<Integer, Integer> map = new HashMap<>();
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			int max = Math.max(map.getOrDefault(nums[i] + 1, 0), map.getOrDefault(nums[i] - 1, 0));
			map.put(nums[i], max + 1);
			ans = Math.max(ans, max + 1);
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
    	for(int i=0;i<N;i++)
	    nums[i] = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestSubsequence(nums));
    }
}
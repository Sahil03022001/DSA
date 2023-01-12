import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //Write code here
		int n = asteroids.length;
		Stack<Integer> st = new Stack<>();
		for(int ast : asteroids){

			if(ast >= 0){
				st.push(ast);
			}
			else{

				while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast)){
					st.pop();
				}

				if(st.isEmpty() || st.peek() < 0){
					st.push(ast);
				}

				if(st.peek() == Math.abs(ast)){
					st.pop();
				}
			}
		}
		int[] ans = new int[st.size()];
		int i = ans.length - 1;
		while(st.size() > 0){
			ans[i--] = st.pop();
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.asteroidCollision(arr);
        for (int i = 0; i < result.length; ++i)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}
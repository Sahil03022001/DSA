import java.io.*;
import java.util.*;

class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
	static int[] nextGreaterEleLeftIndex(int[] a){

		Stack<Integer> s = new Stack<>();
		int[] ans = new int[a.length];
		for(int i = a.length - 1; i >= 0; i--){

			while(s.size() > 0 && a[i] > a[s.peek()]){
				int idx = s.pop();
				ans[idx] = i;
			}
			s.push(i);
		}
		while(s.size() > 0){
			int idx = s.pop();
			ans[idx] = -1;
		}
		return ans;
	}
	
    static int[] stockSpan(int[] a) {

		int[] ngeli = nextGreaterEleLeftIndex(a);
		int[] ans = new int[a.length];
		for(int i = 0; i < a.length; i++){
			ans[i] = i - ngeli[i];
		}
		return ans;
    }
}

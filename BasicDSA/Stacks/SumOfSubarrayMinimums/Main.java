import java.io.*;
import java.util.*;

class Solution{
	int mod = 1000000007;
	public long minSubarraySum(int n, int a[]){
		// write code here
		Stack<Integer> st = new Stack<>();
		long totalSum = 0;
		
		for(int i = 0; i < n; i++){

			while(st.size() > 0 && a[i] < a[st.peek()]){

				int r = i;
				int cidx = st.pop();
				int l = -1;
				if(st.size() != 0){
					l = st.peek();
				}

				long sum = ((r - cidx) * (cidx - l)) % mod;
				totalSum += (sum * a[cidx]) % mod;
			}
			st.push(i);
		}

		while(st.size() > 0){
			int r = n;
			int cidx = st.pop();
			int l = -1;
			if(st.size() != 0){
				l = st.peek();
			}

			long sum = ((r - cidx) * (cidx - l)) % mod;
			totalSum += (sum * a[cidx]) % mod;
		}
		return totalSum % mod;
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
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}
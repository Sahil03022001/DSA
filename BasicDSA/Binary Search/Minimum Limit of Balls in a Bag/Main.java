import java.util.*;
import java.io.*;
class Solution
{
	static int countOfOps(int[] arr, int n, int limit){

		int myOps = 0;
		for(int i = 0; i < n; i++){
			int currOps = arr[i] / limit;
			if(arr[i] % limit == 0){
				currOps--;
			}
			myOps += currOps;
		}
		return myOps;
	}
	
    public static int solve(int n,int m,int arr[])
    {
        // Write your code here
		int lo = 1;
		int hi = arr[0];
		for(int i = 1; i < n; i++){
			hi = Math.max(hi, arr[i]);
		}

		int ans = -1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(countOfOps(arr, n, mid) <= m){
				ans = mid;
				hi = mid - 1;
			}
			else{
				lo = mid + 1;
			}
		}
		return ans;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}
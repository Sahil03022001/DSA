
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        //your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(solve(arr, n, k));
    }
	
	static int solve(int[] arr, int n, int k){

		int ans = -1;
		int lo = 0;
		int hi = n - 1;
		while(lo <= hi){

			int mid = (lo + hi) / 2;

			if(arr[mid] == k){
				return mid;
			}
			else if(arr[mid] > k){
				hi = mid - 1;
			}
			else{
				ans = mid;
				lo = mid + 1;
			}
		}
		return ans;
	}
}
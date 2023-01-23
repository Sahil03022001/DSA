import java.io.*;
import java.util.*;


class Main {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution ob = new Solution();
        
        System.out.println(ob.KthSmallest(m,n, k));
        
	}
}

class Solution {

	int countOfLessNumbers(int rows, int cols, int num){

		int cnt = 0;
		for(int i = 0; i < rows; i++){
			int lo = 0;
			int hi = cols - 1;

			while(lo <= hi){
				int mid = (lo + hi) / 2;

				if((i + 1) * (mid + 1) <= num){
					lo = mid + 1;
				}
				else{
					hi = mid - 1;
				}
			}

			cnt += lo;
		}

		return cnt;
	}
	
    public int KthSmallest(int m, int n, int k) {
        //Write your code here
        int lo = 1;
		int hi = m * n;
		int ans = 0;
		while(lo <= hi){
			int mid = (lo + hi) / 2;

			if(countOfLessNumbers(m, n, mid) >= k){
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
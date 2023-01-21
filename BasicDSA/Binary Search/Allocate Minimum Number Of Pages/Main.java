import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	private boolean possibleToPlace(int[] A, int B, long maxPages){

		long currPages = 0;
		int stud = 1;
		for(int val : A){
			if(currPages + val <= maxPages){
				currPages += val;
			}else{
				currPages = val;
				stud++;
			} 
		}

		return stud <= B;
	}
    public long MinimumPages(int[] A, int B) {
        //Write your code here
		if(B > A.length)return -1;

		long lo = A[0];
		long hi = A[0];
		for(int val : A){
			lo = Math.max(lo, val);
			hi += val;
		}

		long ans = 0;
		while(lo <= hi){

			long mid = (lo + hi) / 2;

			if(possibleToPlace(A, B, mid)){
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

class Main {
    

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution(); 
        System.out.println(Obj.MinimumPages(A,B));
	}
}
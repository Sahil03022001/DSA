import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{

	static boolean possibleToShip(int[] A, long maxCap, int B){

		int days = 1;
		long currCap = A[0];
		for(int i = 1; i < A.length; i++){
			if(A[i] + currCap <= maxCap){
				currCap += A[i];
			}
			else{
				currCap = A[i];
				days++;
			}
		}

		return days <= B;
	}
    public static long solve(int[] A, int B) {
        //Write your code here

		long lo = A[0];
		long hi = A[0];
		for(int i = 1; i < A.length; i++){
			lo = Math.max(lo, A[i]);
			hi += A[i];
		}

		long ans = -1;
		while(lo <= hi){
			long mid = (lo + hi) / 2;
			if(possibleToShip(A, mid, B)){
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
        public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
        	int[] A = new int[n];
        	for(int i=0;i<n;i++){
                        A[i] = sc.nextInt();
		}
                int B = sc.nextInt();
                System.out.println(Solution.solve(A,B));
	}
}
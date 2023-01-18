import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int N = sc.nextInt();
	  int[] A = new int[N];
	  for(int i=0;i<N;i++){
          A[i] = sc.nextInt();
      }
	  int B = sc.nextInt();
	  Solution ob = new Solution();
    System.out.println(ob.search(A,B));
		
	}
}

class Solution{
    public int search(final int[] a, int target) {
        //Write code here
		int n = a.length;
		if(n == 1){
			if(a[0] == target)return 0;
			return -1;
		}
		
		if(a[0] < a[n - 1]){
			return binarySearch(a, target, 0, n - 1);
		}

		int pivot = findPivot(a, 0, n - 1);
		
		int findAtLeftOfPivot = binarySearch(a, target, 0, pivot - 1);
		if(findAtLeftOfPivot != -1)return findAtLeftOfPivot;

		return binarySearch(a, target, pivot, n - 1);
		
    }

	int findPivot(int[] a, int lo, int hi){

		while(lo <= hi){

			int mid = (lo + hi) / 2;

			if(a[mid + 1] < a[mid]){
				return mid + 1;
			}
			else if(a[mid] < a[mid - 1]){
				return mid;
			}
			else if(a[mid] > a[lo]){
				lo = mid + 1;
			}
			else{
				hi = mid - 1;
			}
		}
		return -1;
	}

	int binarySearch(int[] a, int x, int lo, int hi){

		while(lo <= hi){

			int mid = (lo + hi) / 2;

			if(a[mid] == x){
				return mid;
			}
			else if(a[mid] > x){
				hi = mid - 1;
			}
			else{
				lo = mid + 1;
			}
		}
		return -1;
	}
}
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        // your code here
		int lo = 1;
		int hi = A;
		int ans = 0;
		while(lo <= hi){

			int mid = (lo + hi) / 2;
			if(mid == A / mid){
				ans = mid;
				break;
			}
			else if(mid > A / mid){
				hi = mid - 1;
			}
			else{
				ans = mid;
				lo = mid + 1;
			}
		}

		System.out.println(ans);
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}
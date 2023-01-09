import java.io.*;
import java.util.*;

class Solution {
    public void TappingWater(int[] arr, int n) {
        //Write code here and print output
        
       int LB = arr[0];
		int RB = arr[n - 1];

		int l = 1;
		int r = n - 2;
		int ans = 0;

		while(l <= r){
			if(LB <= RB){
				if(arr[l] > LB){
					LB = arr[l];
				}else{
					ans += LB - arr[l];
				}
				l++;
			}
			else{
				if(arr[r] > RB){
					RB = arr[r];
				}else{
					ans += RB - arr[r];
				}
				r--;
			}
		}
		System.out.println(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}
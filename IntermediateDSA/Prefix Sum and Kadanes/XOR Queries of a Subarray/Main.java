import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	  public static void main(String[] args) throws Throwable {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int q = sc.nextInt();
	        int [] arr= new int[n];
	        for(int i=0;i<n;i++){
	            arr[i]=sc.nextInt();
	        }
	        int [][] queries= new int[q][2];
	        for(int i=0;i<q;i++){
	            for(int j=0;j<2;j++){
	                queries[i][j]=sc.nextInt();
	            }
	        }
	        Solution Obj= new Solution();
	        
	        int [] result = Obj.xorQueries(arr,queries);
	        for(int i=0;i<result.length;i++){
	            System.out.print(result[i]+" ");
	    }
	}
}
class Solution{
  
	public static int[] xorQueries(int[] A, int[][] queries) {
	    // your code goes here
		 int n = A.length;

		//generating prefix XOR
		int[] preXor = new int[n];
		preXor[0] = A[0];
		for(int i = 1; i < n; i++){
			preXor[i] = A[i] ^ preXor[i - 1];
		}

		//generating answer for each query
		int[] res = new int[queries.length];
		int k = 0;
		for(int[] i : queries){
			int sp = i[0];
			int ep = i[1];

			res[k++] = sp == 0 ? preXor[ep] : preXor[ep] ^ preXor[sp - 1];
		}

		return res;
	}   
}
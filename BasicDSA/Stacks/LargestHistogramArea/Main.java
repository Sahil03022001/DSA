import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution
{
	static int[] nextSmallerEleLeftIndex(long[] arr, int n){

		int[] nseli = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i = n - 1; i >= 0; i--){
			while(stack.size() > 0 && arr[i] < arr[stack.peek()]){
				int idx = stack.pop();
				nseli[idx] = i;
			}
			stack.push(i);
		}
		
		while(stack.size() > 0){
			int idx = stack.pop();
			nseli[idx] = -1;
		}
		return nseli;
	}

	static int[] nextSmallerEleRightIndex(long[] arr, int n){

		int[] nseri = new int[n];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++){
			while(stack.size() > 0 && arr[i] < arr[stack.peek()]){
				int idx = stack.pop();
				nseri[idx] = i;
			}
			stack.push(i);
		}
		
		while(stack.size() > 0){
			int idx = stack.pop();
			nseri[idx] = n;
		}
		return nseri;
	}
	
      public static long maximumArea(long hist[], long n){

		  int[] nseli = nextSmallerEleLeftIndex(hist, (int)n);
		  int[] nseri = nextSmallerEleRightIndex(hist, (int)n);

		  long maxArea = 0;
		  for(int i = 0; i < (int)n; i++){
			  long height = hist[i];
			  long width = nseri[i] - nseli[i] - 1;
			  long area = height * width;
			  maxArea = Math.max(maxArea, area);
		  }
		  return maxArea;
	  }
}
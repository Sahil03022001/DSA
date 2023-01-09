import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        //Write code here and print output
		long ngre[] = new long[n];
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < n; i++){

			while(s.size() > 0 && arr[s.peek()] < arr[i]){
				int idx = s.peek();
				ngre[idx] = arr[i];
				s.pop();
			}
			s.push(i);
		}
		while(s.size() > 0){
			ngre[s.peek()] = -1;
			s.pop();
		}
		return ngre;
    } 
}
class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}

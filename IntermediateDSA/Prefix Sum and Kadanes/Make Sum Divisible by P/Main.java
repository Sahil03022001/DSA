import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,q;
        n=sc.nextInt();
        q=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.minSubarray(a,n,q));		    
    }
}

class Solution
{
	final static int mod = (int) 1e9 + 7;
  public int minSubarray(int[] A,int n, int p) {
      //Write code here

	  long sum = 0;
        for(int a : A){
            sum = (sum + a) % p;
        }

        if(sum % p == 0) return 0;
        int rem = ((int)sum % p + p) % p;

	    //finding shortest subarray with sum equal to rem
	    Map<Integer, Integer> map = new HashMap<>();
	    int res = n;
        long pSum = 0;
	    map.put(0, -1);
	    for(int i = 0; i < n; i++){
            pSum = (pSum + A[i]) % p;
            int currRem = ((int)pSum % p + p) % p;
            int remToSearch = ((currRem - rem) % p + p) % p;
		    if(map.containsKey(remToSearch)){
			  res = Math.min(res, i - map.get(remToSearch));
		    }
		    map.put(currRem, i);
	    }

	    return res == n ? -1 : res;
    }
  }
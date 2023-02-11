import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        //Write code here
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int res = 0;
		for(int key : map.keySet()){
			if(k == 0){
				if(map.get(key) > 1) res++;
			}else{
				if(map.containsKey(key + k)){
					res++;
				}
			}
		}

		return res;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public long pairDifference(int []A, int n, int k) {
       // write code here
		long count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}

		for(int i : map.keySet()){
			if(k == 0){
				if(map.get(i) > 1)count++;
			}else{
				if(map.containsKey(k + i) && map.get(k + i) >= 1)count++;
			}
		}
		return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}

import java.util.*;

class Solution {
    static int countEqualSubarray01(int arr[], int n)
    {
        //Write your code here
        int c0 = 0, c1 = 0;
		int ans = 0;
		Map<Integer, Integer> map = new HashMap();
		for(int i = 0; i < n; i++){

			if(arr[i] == 0)c0++;
			else c1++;

			int d10 = c1 - c0;
			if(d10 == 0){
				ans++;
			}
			if(map.containsKey(d10)){
				ans += map.get(d10);
				map.put(d10, map.get(d10) + 1);
			}
			else{
				map.put(d10, 1);
			}
		}
		return ans;
	} 
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray01(arr,N));

    }
}
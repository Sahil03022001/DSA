import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		LinkedList<Integer> q = new LinkedList<>();
		int[] ans = new int[N - K + 1];
		int j = 0;
		for(int i = 0; i < arr.length; i++){

			if(q.isEmpty()){
				q.add(i);
			}
			else{

				if(!q.isEmpty() && q.getFirst() == i - K){
					q.poll();
				}
				
				while(!q.isEmpty() && arr[q.getLast()] < arr[i]){
					q.pollLast();
				}
				q.add(i);

				if(i >= K - 1){
					ans[j++] = arr[q.peek()];
				}
			}
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}

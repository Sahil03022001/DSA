import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Write your code here
		int minSum = Integer.MAX_VALUE;
		int curSumForMin = 0;
		int maxSum = Integer.MIN_VALUE;
		int curSumForMax = 0;
		int wholeSum = 0;
		
		for(int i = 0; i < n; i++){
			wholeSum += arr[i];

			//maxSum
			curSumForMax = Math.max(arr[i], curSumForMax + arr[i]);
			maxSum = Math.max(maxSum, curSumForMax);

			//minSum
			curSumForMin = Math.min(arr[i], curSumForMin + arr[i]);
			minSum = Math.min(minSum, curSumForMin);
		}

		if(minSum >= 0) return maxSum;

		return Math.max(maxSum, wholeSum - minSum);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}
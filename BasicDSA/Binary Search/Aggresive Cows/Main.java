import java.io.*;
import java.util.*;
import java.util.*;

class Solution{

    public static int aggressiveCows(int arr[],int cows){
       //Write your code here
		//sorting is done to have a clear picture how to place 2 cows
		Arrays.sort(arr);
	
		int lo = 1;
		int hi = arr[arr.length - 1] - arr[0];
		int ans = 0;
		while(lo <= hi){
		
			int mid = (lo + hi) / 2;

			if(possibleToPlace(arr, cows, mid)){
				ans = mid;
				lo = mid + 1;
			}
			else{
				hi = mid - 1;
			}
		}
		return ans;
    }

	static boolean possibleToPlace(int[] arr, int cows, int minDist){
	
		int cowsPlaced = 1;
		int lastPlaced = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(arr[i] - lastPlaced >= minDist){
				lastPlaced = arr[i];
				cowsPlaced++;
			}
		}
		return cowsPlaced >= cows;
	}


}

class Main {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution obj=new Solution();
		System.out.println(obj.aggressiveCows(nums,k));

    }
}
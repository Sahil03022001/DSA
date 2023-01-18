import java.util.*;

class Solution {
    static int count1(int size, int arr[]) {
        //Write your code here
		if(arr[0] != 1 && arr[size - 1] != 1)return 0;
		int left = findLeftMostIndex(arr, 0, size - 1);
		int right = findRightMostIndex(arr, 0, size - 1);
		return right - left + 1;
    }

	static int findLeftMostIndex(int[] arr, int lo, int hi){

		int ans = 0;
		while(lo <= hi){

			int mid = (lo + hi) / 2;

			if(arr[mid] == 1){
				ans = mid;
				hi = mid - 1;
			}
			else{
				hi = mid - 1;
			}
		}

		return ans;
	}

	static int findRightMostIndex(int[] arr, int lo, int hi){

		int ans = 0;
		while(lo <= hi){

			int mid = (lo + hi) / 2;

			if(arr[mid] == 1){
				ans = mid;
				lo = mid + 1;
			}
			else{
				hi = mid - 1;
			}
		}
		return ans;
	}

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n,array));
    }
}

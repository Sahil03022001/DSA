// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int arr[], int l, int r)
    {
        //Write your code here
		if(arr[0] < arr[r]){
			return arr[0];
		}

		while(l <= r){

			int m = (l + r) / 2;

			if(arr[m + 1] < arr[m]){
				return arr[m + 1];
			}
			else if(arr[m] < arr[m - 1]){
				return arr[m];
			}
			else if(arr[m] > arr[l]){
				l = m + 1;
			}
			else{
				r = m - 1;
			}
		}

		return -1;
    }
}
class Main {
    
 
    // Driver Program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
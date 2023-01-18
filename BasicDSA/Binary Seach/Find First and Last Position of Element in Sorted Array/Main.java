import java.util.*;

public class Main {

	static int findLeftIndex(int[] a, int n, int k){

		int ans = -1;
		int l = 0;
		int r = n - 1;

		while(l <= r){

			int m = (l + r) / 2;
			
			if(a[m] == k){
				ans = m;
				r = m - 1;
			}
			else if(a[m] > k){
				r = m - 1;
			}
			else{
				l = m + 1;
			}
		}

		return ans;
	}

	static int findRightIndex(int[] a, int n, int k){

		int ans = -1;
		int l = 0;
		int r = n - 1;

		while(l <= r){

			int m = (l + r) / 2;

			if(a[m] == k){
				ans = m;
				l = m + 1;
			}
			else if(a[m] > k){
				r = m - 1;
			}
			else{
				l = m + 1;
			}
		}

		return ans;
	}
    public static void findPosition(int a[], int n,int k)
    {
        // Write code here
		int left = findLeftIndex(a, n, k);
		int right = findRightIndex(a, n, k);

		System.out.print(left + " " + right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}
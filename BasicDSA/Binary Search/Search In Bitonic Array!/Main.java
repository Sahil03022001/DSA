
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();
        
        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);
    
    }
}


class Accio {
    
    static int findElement(int arr[], int n,int target)
    {
        // your code here
		if(n == 1){
			if(arr[0] == target)return 0;
			return -1;
		}
		if(n == 2){
			if(arr[0] != target || arr[1] != target)return -1;
			if(arr[0] == target)return 0;
			return 1;
		}
		
		int lo = 0;
		int hi = arr.length - 1;
		int peak = -1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(arr[mid] == target)return mid;
			else if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
				peak = mid;
				break;
			}
			else if(arr[mid - 1] > arr[mid]){
				hi = mid -  1;
			}
			else{
				lo = mid + 1;
			}
		}

		lo = 0;
		hi = peak - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(arr[mid] == target)return mid;
			else if(arr[mid] > target){
				hi = mid - 1;
			}else{
				lo = mid + 1;
			}
		}

		lo = peak + 1;
		hi = n - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(arr[mid] == target)return mid;
			else if(arr[mid] > target){
				lo = mid + 1;
			}else{
				hi = mid - 1;
			}
		}

		return -1;
    }
}
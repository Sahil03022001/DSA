import java.io.*;
import java.util.*;

public class Main {

    public static int subarrayDivisbleByK(int arr[], int n, int k){
        // Write code here 
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int cnt = 0;
		map.put(0, 1);
		for(int val : arr){
			sum += val;
			int temp = sum % k;
			if(temp < 0)temp += k;
			if(map.containsKey(temp)){
				cnt += map.get(temp);
			}
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}
		return cnt;
    }
	
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = subarrayDivisbleByK(arr, n, k);
        System.out.print(result);        
        System.out.println('\n');
    }
}
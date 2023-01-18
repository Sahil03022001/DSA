import java.util.*;

public class Main {
    public static int findIndex(int key, int[] arr) {
        //Write code here
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            //find mid index
            int mid = (start + end) / 2;

            //key found
            if(arr[mid] == key){
                return mid;
            }

            //key cannot be on left side
            else if(arr[mid] < key){
                start = mid + 1;
            }

            //key cannot be on the right side
            else{
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr));
        sc.close();
    }
}
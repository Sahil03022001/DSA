import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            int diff = k - nums[i];
            if(diff < 0) continue;
            if(map.containsKey(diff)){
                cnt++;
                map.put(diff, map.get(diff) - 1);
                if(map.get(diff) == 0) map.remove(diff);
            }else{
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.maxOperations(arr, k);
        System.out.println(result);
        sc.close();
    }
}
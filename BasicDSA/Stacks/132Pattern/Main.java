import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        //Write code here
		int s3 = Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<>();
		for(int i = nums.length - 1; i >= 0; i--){
			if(nums[i] < s3){
				return true;
			}else{
				while(st.size() > 0 && st.peek() < nums[i]){
					s3 = st.pop();
				}
				st.push(nums[i]);
			}
		}
		return false;
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
        Solution Obj = new Solution();
        boolean result = Obj.find132pattern(arr);
        if (result)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}
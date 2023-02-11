import java.util.*;

class Solution {

    public int solve(int nums[],int n) {
        // Your code here

		//generate min prefix array
        int[] minPref = new int[n];
        minPref[0] = nums[0];
        for(int i = 1; i < n; i++){
            minPref[i] = Math.min(minPref[i - 1], nums[i]);
        }

        //generate max prefix array
        int[] maxPref = new int[n];
        maxPref[n - 1] = nums[n - 1];
        for(int i = n - 2; i > -1; i--){
            maxPref[i] = Math.max(maxPref[i + 1], nums[i]);
        }

        //generate max width ramp
        int res = 0;
        int i = 0, j = 0;
        while(i < n && j < n){
            if(minPref[i] <= maxPref[j]){
                j++;
            }else{
                i++;
            }
            res = Math.max(res, j - i - 1);
        }

        return res;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}
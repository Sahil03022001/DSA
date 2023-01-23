public class Solution {

    static int countOfLessNumbers(int[] row1, int[] row2, int m, int n, int num){

        int totalCnt = 0;

        int lo = 0;
        int hi = m - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(row1[mid] <= num){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }

        totalCnt += lo;

        lo = 0;
        hi = n - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(row2[mid] <= num){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }

        totalCnt += lo;
        
        return totalCnt;
    }
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        int lo = Math.min(row1[0], row2[0]);
        int hi = Math.max(row1[m - 1], row2[n - 1]);

        int ans = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(countOfLessNumbers(row1, row2, m, n, mid) >= k){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        return ans;
    }
}

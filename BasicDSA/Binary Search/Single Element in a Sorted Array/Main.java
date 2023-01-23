import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
        int n = arr.size();

        int lo = 0;
        int hi = n - 2;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(arr.get(mid) == arr.get(mid ^ 1)){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }

        return arr.get(lo);
    }
}
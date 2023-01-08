package IntroToDSA.Arrays.SortArrayOf0,1,2;

public class Solution {
    public static void sort012(int[] arr)
    {
        //Write your code here
        int x = 0, y = 0, z = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0)x++;
            else if(arr[i] == 1)y++;
            else z++;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(x > 0){
                arr[i] = 0;
                x--;
            }
            else if(y > 0){
                arr[i] = 1;
                y--;
            }
            else{
                arr[i] = 2;
                z--;
            }
        }
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int lo = 0;
        int hi = arr.length - 1;

        while(lo <= hi){

            int mid = (lo + hi) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                return mid;
            }
            else if(arr[mid - 1] > arr[mid]){
                hi = mid;
            }
            else{
                lo = mid;
            }
        }

        return -1;
    }
}
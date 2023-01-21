class Solution {
    
    private boolean AbleToMake(int[] arr, int m, int k, int daysWaited){
        
        int bouquetsMade = 0;
        int countForFlowers = 0;
        
        for(int val : arr){
            
            if(val <= daysWaited){
                countForFlowers++;
            }else{
                countForFlowers = 0;
            }
            
            if(countForFlowers == k){
                countForFlowers = 0;
                bouquetsMade++;
            }
            
            if(bouquetsMade == m)break;
        }
        
        return bouquetsMade == m;
        
    }
    
    public int minDays(int[] arr, int m, int k) {
        
        int n = arr.length;
        
        if(m * k > n)return -1;
        
        int lo = 0;
        int hi = 0;
        for(int val : arr){
            lo = Math.min(lo, val);
            hi = Math.max(hi, val);
        }
        
        int ans = -1;
        while(lo <= hi){
            
            int mid = (lo + hi) / 2;
            
            if(AbleToMake(arr, m, k, mid)){
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
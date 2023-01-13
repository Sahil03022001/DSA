class Compute {
    public int findElement(int arr[], int n){
        
        int[] lmax = new int[n];
        lmax[0] = arr[0];
        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        }
        
        int[] rmin = new int[n];
        rmin[n - 1] = arr[n - 1];
        for(int i = n - 2; i > -1; i--){
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }
        
        for(int i = 1; i < n - 1; i++){
            if(lmax[i - 1] <= arr[i] && arr[i] <= rmin[i + 1]){
                return arr[i];
            }
        }
        return -1;
    }
}
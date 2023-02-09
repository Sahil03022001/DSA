class Solution {

    private long rangeSum(long[] arr, int sp, int ep){
        if(sp > ep) return 0;
        if(sp == 0) return arr[ep];
        return arr[ep] - arr[sp - 1];
    }

    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;

        //generate prefix sum for row 1
        long[] row0 = new long[n];
        row0[0] = grid[0][0];
        for(int i = 1; i < n; i++){
            row0[i] = grid[0][i] + row0[i - 1];
        }

        //generate prefix sum for row 2
        long[] row1 = new long[n];
        row1[0] = grid[1][0];
        for(int i = 1; i < n; i++){
            row1[i] = grid[1][i] + row1[i - 1];
        }

        //finding Overall minimum of each maximum sum robot2 can obtain
        long res = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long option1 = rangeSum(row0, i + 1, n - 1);
            long option2 = rangeSum(row1, 0, i - 1);

            long maxSumEachStep = Math.max(option1, option2);
            res = Math.min(res, maxSumEachStep);
        }

        return res;
    }
}
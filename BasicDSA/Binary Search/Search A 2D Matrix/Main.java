import java.util.*;

public class Main {
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        //Write your code here
            // Return true or false
		int n = mat.length;
		int m = mat[0].length;
		
		int lo = 0;
		int hi = n - 1;
		int row = 0;
		while(lo <= hi){

			int mid = (lo + hi) / 2;
			if(mat[mid][0] == x){
				return true;
			}
			else if(mat[mid][0] > x){
				// row = mid;
				hi = mid - 1;
			}
			else{
				row = mid;
				lo = mid + 1;
			}
		}

		lo = 0;
		hi = m - 1;
		while(lo <= hi){

			int mid = (lo + hi) / 2;

			if(mat[row][mid] == x){
				return true;
			}
			else if(mat[row][mid] > x){
				hi = mid - 1;
			}
			else{
				lo = mid + 1;
			}
		}

		return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
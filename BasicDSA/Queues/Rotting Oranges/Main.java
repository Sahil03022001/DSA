import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	  public static void main (String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int [][] arr= new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        Solution obj= new Solution();
	        
	        System.out.println(obj.orangesRotting(arr));
		}
}
class Solution{     
	static class Pair{

		int row;
		int col;
		int tm;

		Pair(int row, int col, int tm){
			this.row = row;
			this.col = col;
			this.tm = tm;
		}
		
	}
	
	 public static int orangesRotting(int[][] grid){

		 int m = grid.length;
		 int n = grid[0].length;

		 LinkedList<Pair> q = new LinkedList<>();
		 int[][] vis = new int[m][n];
		 int fresh = 0;
		 for(int i = 0; i < m; i++){
			 for(int j = 0; j < n; j++){

				 if(grid[i][j] == 2){
					 q.offer(new Pair(i, j, 0));
					 vis[i][j] = 2;
				 }
				 else{
					 vis[i][j] = 0;
				 }

				 if(grid[i][j] == 1)fresh++;
			 }
		 }

		 int tm = 0;
		 int drow[] = {-1, 0, 1, 0};
		 int dcol[] = {0, 1, 0, -1};
		 int count = 0;

		 while(q.size() > 0){

			 int r = q.peek().row;
			 int c = q.peek().col;
			 int t = q.peek().tm;
			 tm = Math.max(tm, t);

			 q.poll();

			 for(int i = 0; i < 4; i++){
				 int nrow = r + drow[i];
				 int ncol = c + dcol[i];
				 if(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
					 vis[nrow][ncol] = 2;
					 q.add(new Pair(nrow, ncol, tm + 1));
					 count++;
				 }
			 }
		 }

		 if(count != fresh)return -1;
		 return tm;
	 }
}

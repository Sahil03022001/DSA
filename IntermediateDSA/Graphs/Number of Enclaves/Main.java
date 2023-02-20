import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

	static void dfs(int i, int j, int[][] grid){
		if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j]==0){
			return;
		}

		grid[i][j] = 0;
		dfs(i-1, j, grid);
		dfs(i, j-1, grid);
		dfs(i+1, j, grid);
		dfs(i, j+1, grid);
	}
	
  public static int numEnclaves(int[][] grid) {
    // your code here
	  int n = grid.length;
	  int m = grid[0].length;
	  for(int i=0; i<n; i++){
		  if(i == 0){
			  for(int j=0; j<m; j++){
				  dfs(i, j, grid);
			  }
		  }else if(i == n-1){
			  for(int j=0; j<m; j++){
				  dfs(i, j, grid);
			  }
		  }else{
			  dfs(i, 0, grid);
			  dfs(i, m-1, grid);
		  }
	  }

	  int cnt = 0;
	  for(int i=0; i<n; i++){
		  for(int j=0; j<m; j++){
			  if(grid[i][j] == 1) cnt++;
		  }
	  }

	  return cnt;
  }
}
import java.util.*;

class Solution {

	private static String toString(int r, int c){
		return Integer.toString(r) + "" + Integer.toString(c);
	}
	static void dfs(int r, int c, int[][] grid, boolean[][] vis, int baseRow, int baseCol, ArrayList<String> list){

		vis[r][c] = true;
		list.add(toString(r-baseRow, c-baseCol));

		//top dir
		if(r-1>=0 && grid[r-1][c]==1 && !vis[r-1][c]){
			dfs(r-1, c, grid, vis, baseRow, baseCol, list);
		}

		//right dir
		if(c+1<grid[0].length && grid[r][c+1]==1 && !vis[r][c+1]){
			dfs(r, c+1, grid, vis, baseRow, baseCol, list);
		}

		//down dir
		if(r+1<grid.length && grid[r+1][c]==1 && !vis[r+1][c]){
			dfs(r+1, c, grid, vis, baseRow, baseCol, list);
		}

		//left dir
		if(c-1>=0 && grid[r][c-1]==1 && !vis[r][c-1]){
			dfs(r, c-1, grid, vis, baseRow, baseCol, list);
		}
		
	}
	
  public static int countDistinctIslands(int[][] grid) {
    // write your code here
	  int n = grid.length;
	  int m = grid[0].length;
	  boolean[][] vis = new boolean[n][m];
	  Set<ArrayList<String>> set = new HashSet<>();
	  for(int i=0; i<n; i++){
		  for(int j=0; j<m; j++){
			  if(!vis[i][j] && grid[i][j] == 1){
				  ArrayList<String> list = new ArrayList<>();
				  dfs(i, j, grid, vis, i, j, list);
				  set.add(list);
			  }
		  }
	  }

	  return set.size();
  }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

class Pair {
    int row;
    int col;
    int dist;
    Pair(int r, int c, int d){
        row = r;
        col = c;
        dist = d;
    }
}
public class Main
{
    public static int[][] nearest(int[][] grid)
    {
        // your code here
		int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        
        int[][] res = new int[n][m];
        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;
            int d = p.dist;
            
            if(vis[i][j]) continue;
            res[i][j] = d;
            vis[i][j] = true;
            
            if(i-1>=0 && !vis[i-1][j]){
                q.add(new Pair(i-1, j, d+1));
            }
            
            if(j-1>=0 && !vis[i][j-1]){
                q.add(new Pair(i, j-1, d+1));
            }
            
            if(i+1<n && !vis[i+1][j]){
                q.add(new Pair(i+1, j, d+1));
            }
            
            if(j+1<m && !vis[i][j+1]){
                q.add(new Pair(i, j+1, d+1));
            }
        }
        
        return res;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            int[][] ans = nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
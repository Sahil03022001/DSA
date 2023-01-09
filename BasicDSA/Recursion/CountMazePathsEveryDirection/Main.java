import java.util.*;

public class Main {
    static int countAllPath(int n, int m)
    {
        //Write your code here
		boolean visited[][] = new boolean[n][m];
		return solve(0, 0, n - 1, m - 1, visited);
    }
	static int solve(int sr, int sc, int dr, int dc, boolean[][] visited){
		if(sr == dr && sc == dc)return 1;
		if(sr < 0 || sc < 0 || sr > dr || sc > dc)return 0;
		if(visited[sr][sc])return 0;
		// if(sr < 0 || sc < 0 || sr > dr || sc > dc)return 0;

		visited[sr][sc] = true;
		int count = 0;
		
		//horizontal
		count += solve(sr, sc - 1, dr, dc, visited);
		count += solve(sr, sc + 1, dr, dc, visited);

		//vertical
		count += solve(sr - 1, sc, dr, dc, visited);
		count += solve(sr + 1, sc, dr, dc, visited);

		//diagonal
		count += solve(sr - 1, sc - 1, dr, dc, visited);
		count += solve(sr - 1, sc + 1, dr, dc, visited);
		count += solve(sr + 1, sc - 1, dr, dc, visited);
		count += solve(sr + 1, sc + 1, dr, dc, visited);

		visited[sr][sc] = false;
		return count;
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        System.out.println(countAllPath(n,m));
    }
}

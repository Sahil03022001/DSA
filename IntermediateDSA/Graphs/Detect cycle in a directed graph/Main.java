import java.util.*;
import java.lang.*;
import java.io.*;

	class Solution {
	public boolean isCyclic(int V, ArrayList<Integer>[] adj){

		boolean[] vis = new boolean[V];
		boolean[] path = new boolean[V];
		for(int i=0; i<V; i++){
			if(!vis[i]){
				if(dfs(i, adj, vis, path)) return true;
			}
		}
		return false;
	}

		public boolean dfs(int currNode, ArrayList<Integer>[] adj, boolean[] vis, boolean[] path){

			vis[currNode] = true;
			path[currNode] = true;

			for(int nbr : adj[currNode]){
				if(vis[nbr] && path[nbr]) return true;
				else if(!vis[nbr]){
					if(dfs(nbr, adj, vis, path)) return true;
				}
			}

			path[currNode] = false;
			return false;
		}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
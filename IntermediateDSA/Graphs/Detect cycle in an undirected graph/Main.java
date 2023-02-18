import java.io.*;
import java.util.*;

class Solution {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       // Your code here
		boolean[] vis = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<V; i++){
			if(vis[i]) continue;
			q.add(i);
			while(q.size() > 0){
				int curr = q.poll();
				if(vis[curr]) return true;
				vis[curr] = true;
				for(int nbr : adj.get(curr)){
					if(!vis[nbr]) q.add(nbr);
				}
			}	
		}
		return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
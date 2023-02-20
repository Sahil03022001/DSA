import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean dfs(int currNode, List<List<Integer>> graph, boolean[] vis, List<Integer> psf, int src){

		int totalNodes = graph.size() - 1;
		if(psf.size()+1 == totalNodes){
			psf.add(currNode);
			System.out.print(psf);
			psf.remove(psf.size()-1);

			boolean isCycle = false;
			for(int nbr : graph.get(currNode)){
				if(nbr == src){
					isCycle = true;
				}
			}

			if(isCycle) System.out.println("(Cycle)");
			else System.out.println();
			// return isCycle;
		}

		vis[currNode] = true;
		psf.add(currNode);
		boolean isHamiltonial = false;
		for(int nbr : graph.get(currNode)){
			if(!vis[nbr]){
				if(dfs(nbr, graph, vis, psf, src)){
					isHamiltonial = true;
				}
			}
		}
		psf.remove(psf.size()-1);
		vis[currNode] = false;
		return isHamiltonial;
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
	    List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		for(ArrayList<Integer> e : Edges){
			int u = e.get(0);
			int v = e.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] vis = new boolean[N+1];
		List<Integer> psf = new ArrayList<>();
		boolean res = false;
		for(int i=1; i<=N; i++){
			res = res || dfs(i, graph, vis, psf, i);
		}
		return res;
    }
}












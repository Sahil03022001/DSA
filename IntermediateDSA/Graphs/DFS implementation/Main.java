import java.util.*;

class Solution {
	public static void dfs(int currNode, List<List<Integer>> graph, boolean[] vis){

		vis[currNode] = true;
		System.out.print(currNode + " ");
		Collections.sort(graph.get(currNode));
		for(int i : graph.get(currNode)){
			if(!vis[i]) dfs(i, graph, vis);
		}
	}
	
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++){
			graph.add(new ArrayList<>());
		}

		for(List<Integer> edge : edges){
			int u = edge.get(0);
			int v = edge.get(1);

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] vis = new boolean[n];
		dfs(0, graph, vis);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}
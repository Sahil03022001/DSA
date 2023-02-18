import java.io.*;
import java.util.*;
  class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{
	static void dfs(int currNode, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> list){
		vis[currNode] = true;
		list.add(currNode);
		for(Edge e : graph[currNode]){
			if(!vis[e.nbr]) dfs(e.nbr, graph, vis, list);
		}
	}
	
    public static int perfectStudents(int V,  ArrayList<Edge>[] graph){
       // Your code here
		boolean[] vis = new boolean[V];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int i=0; i<V; i++){
			if(!vis[i]){
				ArrayList<Integer> list = new ArrayList<>();
				dfs(i, graph, vis, list);
				comps.add(list);
			}
		}

		int res = 0;
		for(int i=0; i<comps.size(); i++){
			for(int j=i+1; j<comps.size(); j++){
				res += comps.get(i).size() * comps.get(j).size();
			}
		}

		return res;
   }
}
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      System.out.println(Solution.perfectStudents(n, graph));
   }

}
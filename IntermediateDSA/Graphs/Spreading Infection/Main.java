import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
	   System.out.print(spreadingInfection(vtces, graph, src, t));
   }

	static int spreadingInfection(int V, ArrayList<Edge>[] graph, int src, int time){

		boolean[] vis = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while(!q.isEmpty() && time > 0){
			int size = q.size();

			while(size > 0){
				int currNode = q.poll();
				vis[currNode] = true;
				for(Edge e : graph[currNode]){
					if(!vis[e.nbr]){
						q.add(e.nbr);
					}
				}
				size--;
			}
			time--;
		}

		int cnt = 0;
		for(int i=0; i<V; i++) if(vis[i]) cnt++;
		return cnt;
	}

}
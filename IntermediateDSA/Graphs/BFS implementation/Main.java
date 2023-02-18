import java.util.*;
import java.io.*;
 
class Graph {
    
}
 
public class Main {
	public static void bfs(int root, List<List<Integer>> graph, boolean[] vis){

		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();

			while(size-- > 0){
				int currNode = q.poll();
				if(!vis[currNode]){
					vis[currNode] = true;
					System.out.print(currNode + " ");
					for(int i : graph.get(currNode)){
						q.add(i);
					}
				}
			}
		}
	}
	
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
		
        List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<>());
		}

		for(int i=0; i<e; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();

			graph.get(u).add(v);
			// graph.get(v).add(u);
		}

		boolean[] vis = new boolean[n+1];
		bfs(0, graph, vis);
    }
}

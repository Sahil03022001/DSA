import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution {
    int components(ArrayList<ArrayList<Integer>> adj, int n) {
       //Your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++) graph.add(new ArrayList<>());
		
		for(int u=0; u<adj.size(); u++){
			for(int v=0; v<adj.get(u).size(); v++){
				if(adj.get(u).get(v) == 1){
					graph.get(u).add(v);
					graph.get(v).add(u);
				}
			}
		}
		
		int cnt = 0;
		boolean[] vis = new boolean[n];
		for(int i=0; i<n; i++){
			if(!vis[i]){
				cnt++;
				bfs(i, graph, vis);
			}
		}
		return cnt;
    }

	void bfs(int root, ArrayList<ArrayList<Integer>> graph, boolean[] vis){

		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		while(q.isEmpty() == false){
			int currNode = q.poll();
			if(!vis[currNode]){
				vis[currNode] = true;
				for(int nbr : graph.get(currNode)){
					if(!vis[nbr]) q.add(nbr);
				}
			}
		}
	}
}
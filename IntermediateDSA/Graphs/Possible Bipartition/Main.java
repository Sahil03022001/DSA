import java.util.*;

class Solution {
   
    public int possibleBipartition(int n, int[][] dislikes) {
        // Write your code here
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
		for(int[] d : dislikes){
			int u = d[0];
			int v = d[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int[] vis = new int[n+1];
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++){
			if(vis[i] != 0) continue;
			vis[i] = 1;
			q.add(i);
			while(!q.isEmpty()){
				int currNode = q.poll();
				for(int nbr : graph.get(currNode)){
					if(vis[nbr] != 0 && vis[nbr] == vis[currNode]) return 0;
					if(vis[nbr] != 0 && vis[nbr] != vis[currNode]) continue;
 					vis[nbr] = vis[currNode] == 1 ? 2 : 1;
					q.add(nbr);
				}
			}
		}
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
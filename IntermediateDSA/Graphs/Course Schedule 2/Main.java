import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] pre) {
    //Write your code here
		//make adj list and indegree arr to inc cnt of those nodes which have prerequisite
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] p : pre){
            int u = p[0];
            int v = p[1];
            graph.get(v).add(u);
            indegree[u]++;
        }

        //add those nodes who dont have prerequisites (who have indegree val 0)
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) if(indegree[i] == 0) q.add(i);

        //make topo arr for topological sort (store correct order of doing courses)
        int[] topo = new int[n];
        int idx = 0;

        //bfs starts
        while(!q.isEmpty()){
            int currNode = q.poll();
            topo[idx++] = currNode;
            for(int nbr : graph.get(currNode)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        if(idx != n) return new int[0];
        return topo;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}
import java.io.*;
import java.util.*;
import java.lang.*;

class Pair {
	int src;
	String psf;
	int wsf;

	Pair(int s, String p, int w){
		src = s;
		psf = p;
		wsf = w;
	}
}

public class Main {
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
  {
     // Write your code here
       int[] res = new int[V];
	  Arrays.fill(res, -1);
	  PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
		  return a.wsf - b.wsf;
	  });
	  
	  pq.add(new Pair(S, ""+S, 0));
	  while(pq.size() > 0){
		  Pair p = pq.poll();
		  int src = p.src;
		  String psf = p.psf;
		  int wsf = p.wsf;
		  if(res[src] != -1) continue;
		  res[src] = wsf;
		  // System.out.println(src + "->" + psf + "@" + wsf);
		  for(ArrayList<Integer> list : adj.get(src)){
			  int nbr = list.get(0);
			  int cost = list.get(1);
			  if(res[nbr] == -1){
				  pq.add(new Pair(nbr, psf+nbr, wsf+cost));
			  }
		  }
	  }

	  return res;
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}

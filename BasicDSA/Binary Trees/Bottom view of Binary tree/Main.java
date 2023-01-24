
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
            System.out.print(num+" ");

            System.out.println();
		}
	}
}
  
class Pair implements Comparable<Pair>{

	Node node;
	int level;

	Pair(Node n, int l){
		node = n;
		level = l;
	}

	@Override
	public int compareTo(Pair o){

		if(this.level == o.level){
			return this.node.data - o.node.data;
		}
		return this.level - o.level;
	}
}

class Solution{

	static int minLevel = 0;
	static int maxLevel = 0;

	private void findMinAndMaxLevel(Node root, int curLevel){

		if(root == null)return;

		findMinAndMaxLevel(root.left, curLevel - 1);
		findMinAndMaxLevel(root.right, curLevel + 1);

		minLevel = Math.min(minLevel, curLevel);
		maxLevel = Math.max(maxLevel, curLevel);
		
	}
	
    public ArrayList <Integer> bottomView(Node root)

    {
        // Your code here
		minLevel = 0;
		maxLevel = 0;
		findMinAndMaxLevel(root, 0);
		int width = maxLevel - minLevel;
		int totalLevels = width + 1;

		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < totalLevels; i++){
			ans.add(i);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(root, -minLevel));

		while(pq.size() > 0){
			int size = pq.size();

			PriorityQueue<Pair> cq = new PriorityQueue<>();
			while(size > 0){
				Pair curPair = pq.poll();

				ans.set(curPair.level, curPair.node.data);

				if(curPair.node.left != null)cq.add(new Pair(curPair.node.left, curPair.level - 1));
				if(curPair.node.right != null)cq.add(new Pair(curPair.node.right, curPair.level + 1));

				size--;
			}

			pq = cq;
		}

		return ans;
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    // Write your code here
            List<List<Integer>> res = makeBinaryTree(indexes, queries);
            return res;
    }
    
    static List<List<Integer>> makeBinaryTree(List<List<Integer>> indexes, List<Integer> queries){
        
        int n = indexes.size();
        int[] leftChilds = new int[n];
        int j = 0;
        for(List<Integer> i : indexes){
            leftChilds[j++] = i.get(0);
        }
        
        int[] rightChilds = new int[n];
        j = 0;
        for(List<Integer> i : indexes){
            rightChilds[j++] = i.get(1);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < queries.size(); i++){
            Node root = buildTree(leftChilds, rightChilds, n, queries.get(i));
            List<Integer> list = new ArrayList<>();
            inOrderTraversal(root, list);
            res.add(list);
        }
        
        return res;
    }
    
    static Node buildTree(int[] leftChilds, int[] rightChilds, int n, int k){
        
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(1);
        q.add(root);
        
        int level = 0;
        while(q.size() > 0){
            int size = q.size();
            level++;
            
            while(size-- > 0){
                
                Node node = q.poll();
                int idx = node.val - 1;
                
                if(level % k == 0){
                    swap(leftChilds, rightChilds, idx);
                }
                
                if(leftChilds[idx] != -1){
                    Node newNode = new Node(leftChilds[idx]);
                    node.left = newNode;
                    q.add(newNode);
                }else{
                    node.left = null;
                }
                
                if(rightChilds[idx] != -1){
                    Node newNode = new Node(rightChilds[idx]);
                    node.right = newNode;
                    q.add(newNode);
                }else{
                    node.right = null;
                }
            }
        }
        
        return root;
    }
    
    static void swap(int[] l, int[] r, int i){
        int temp = l[i];
        l[i] = r[i];
        r[i] = temp;
    }
    
    static void inOrderTraversal(Node root, List<Integer> list){
        
        if(root == null)return;
        
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
    
    static class Node {
        
        int val;
        Node left;
        Node right;
        
        Node(int v){
            val = v;
            left = null;
            right = null;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

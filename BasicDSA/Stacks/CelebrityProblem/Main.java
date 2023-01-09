import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
       Stack<Integer> celeb = new Stack<>();
		for(int i = 0; i < n; i++){
			celeb.push(i);
		}

		while(celeb.size() >= 2){
			int p1 = celeb.pop();
			int p2 = celeb.pop();

			if(M[p1][p2] == 1){
				celeb.push(p2);
			}else{
				celeb.push(p1);
			}
		}

		int celebrity = celeb.pop();

		//check row && column
		for(int c = 0; c < n; c++){
			if(M[celebrity][c] == 1){
				return -1;
			}
			if(celebrity != c && M[c][celebrity] == 0){
				return -1;
			}
		}
		return celebrity;
    }
}

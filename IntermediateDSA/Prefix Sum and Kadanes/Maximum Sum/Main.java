import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {

		int n = A.length;
		int[] cnt = new int[n];
		for(int[] o : ops){
			int sp = o[0];
			int ep = o[1];
			cnt[sp]++;
			if(ep + 1 < n) cnt[ep + 1]--;
		}

		for(int i = 1; i < n; i++){
			cnt[i] += cnt[i - 1];
		}

		Arrays.sort(cnt);
		Arrays.sort(A);

		int mod = (int) 1e9 + 7;
		int score = 0;
		for(int i = 0; i < n; i++){
			score = score%mod + ((cnt[i]%mod * A[i]%mod)%mod)%mod;
		}

		return score;
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}




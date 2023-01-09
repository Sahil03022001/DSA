import java.io.*;
import java.util.*;


class Solution{
    public String smallestNumber(String str){
        // write code here
		Stack<Integer> st = new Stack<>();
		int n = 1;
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < str.length(); i++){

			char ch = str.charAt(i);

			if(ch == 'd'){
				st.push(n);
				n++;
			}else{
				st.push(n);
				n++;
				while(st.size() > 0){
					ans.append(st.pop());
				}
			}
		}
		st.push(n);
		while(st.size() > 0){
			ans.append(st.pop());
		}
		return ans.toString();
    }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}

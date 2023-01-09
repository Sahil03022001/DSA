import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

  public static String reverseParentheses(String s) {
    // your code here
	  LinkedList<Integer> st = new LinkedList<>();
	  char[] ans = new char[s.length()];
	  int j = 0;
	  for(int i = 0; i < s.length(); i++){
		  char ch = s.charAt(i);
		  if(ch == '('){
			  st.addFirst(j);
		  }
		  else if(ch == ')'){
			  int k = st.removeFirst();
			  reverse(ans, k, j - 1);
		  }else{
			  ans[j++] = ch;
		  }
	  }

	  StringBuilder str = new StringBuilder();
	  for(int i = 0; i < ans.length; i++){
		  str.append(ans[i]);
	  }
	  return str.toString();
  }

	static void reverse(char[] arr, int i, int j){

		while(i < j){
			char ch = arr[i];
			arr[i] = arr[j];
			arr[j] = ch;

			i++;
			j--;
		}
	}
}

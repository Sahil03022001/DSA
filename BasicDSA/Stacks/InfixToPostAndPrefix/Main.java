import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluate(exp);
  }
}

class Solution{
	private int eval(int a, int b, char o){
		if(o == '+')return a + b;
		if(o == '-')return a - b;
		if(o == '*')return a * b;
		else return a / b;
	}

	private int precedence(char ch){
		if(ch == '+' || ch == '-')return 1;
		return 2;
	}
	
    public void evaluate(String exp){
        //Write code here
		Stack<Integer> opd = new Stack<>();
		Stack<Character> opr = new Stack<>();

		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);

			if(Character.isDigit(ch)){
				opd.push(ch - '0');
			}
			else if(ch == '('){
				opr.push(ch);
			}
			else if(ch == ')'){
				while(opr.peek() != '('){
					int b = opd.pop();
					int a = opd.pop();
					char o = opr.pop();
					int ans = eval(a, b, o);
					opd.push(ans);
				}
				opr.pop();
			}
			else{
				while(opr.size() > 0 && opr.peek() != '(' && precedence(ch) <= precedence(opr.peek())){
					int b = opd.pop();
					int a = opd.pop();
					char o = opr.pop();
					int ans = eval(a, b, o);
					opd.push(ans);
				}
				opr.push(ch);
			}
		}
		while(opr.size() > 0){
			int b = opd.pop();
			int a = opd.pop();
			char o = opr.pop();
			int ans = eval(a, b, o);
			opd.push(ans);
		}
		System.out.println(opd.pop());
		convertToPostAndPre(exp);
    }

	private void convertToPostAndPre(String exp){

		Stack<String> post = new Stack<>();
		Stack<String> pre = new Stack<>();
		Stack<Character> opr = new Stack<>();

		for(int i = 0; i < exp.length(); i++){
			char ch = exp.charAt(i);

			if(Character.isDigit(ch)){
				post.push(ch + "");
				pre.push(ch + "");
			}
			else if(ch == '('){
				opr.push(ch);
			}
			else if(ch == ')'){
				while(opr.peek() != '('){

					char o = opr.pop();
					
					String post_b = post.pop();
					String post_a = post.pop();
					String ans1 = post_a + post_b + o;

					String pre_b = pre.pop();
					String pre_a = pre.pop();
					String ans2 = o + pre_a + pre_b;

					post.push(ans1);
					pre.push(ans2);
				}
				opr.pop();
			}
			else{
				while(opr.size() > 0 && opr.peek() != '(' && precedence(ch) <= precedence(opr.peek())){

					char o = opr.pop();
					
					String post_b = post.pop();
					String post_a = post.pop();
					String ans1 = post_a + post_b + o;

					String pre_b = pre.pop();
					String pre_a = pre.pop();
					String ans2 = o + pre_a + pre_b;

					post.push(ans1);
					pre.push(ans2);
				}
				opr.push(ch);
			}
		}
		while(opr.size() > 0){
			char o = opr.pop();
					
			String post_b = post.pop();
			String post_a = post.pop();
			String ans1 = post_a + post_b + o;

			String pre_b = pre.pop();
			String pre_a = pre.pop();
			String ans2 = o + pre_a + pre_b;

			post.push(ans1);
			pre.push(ans2);
		}
		System.out.println(post.pop());
		System.out.println(pre.pop());
	}
}               
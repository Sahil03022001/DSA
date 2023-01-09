import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluation(exp);
  }
}

class Solution{
    public void evaluation(String exp){
        //Write code here
		System.out.println(solve(exp));
		convert(exp);
    }

	private int eval(int a, int b, char o){
		if(o == '+')return a + b;
		else if(o == '-'){
			return a - b;
		}else if(o == '*'){
			return a * b;
		}else{
			return a / b;
		}
	}
	
	private int solve(String exp){

		Stack<Integer> opd = new Stack<>();
		for(int i = 0; i < exp.length(); i++){

			char ch = exp.charAt(i);

			if(Character.isDigit(ch)){
				opd.push(ch - '0');
			}else{
				int b = opd.pop();
				int a = opd.pop();
				opd.push(eval(a, b, ch));
			}
		}
		return opd.pop();
	}

	private void convert(String exp){

		Stack<String> infix = new Stack<>();
		Stack<String> prefix = new Stack<>();
		Stack<Integer> opd = new Stack<>();

		for(int i = 0; i < exp.length(); i++){

			char ch = exp.charAt(i);

			if(Character.isDigit(ch)){
				infix.push(ch + "");
				prefix.push(ch + "");
			}
			else{
				String b = infix.pop();
				String a = infix.pop();
				String ans1 = "(" + a + ch + b + ")";
				infix.push(ans1);

				b = prefix.pop();
				a = prefix.pop();
				String ans2 = ch + a + b;
				prefix.push(ans2);
			}
		}
		System.out.println(infix.pop());
		System.out.println(prefix.pop());
	}
}                         

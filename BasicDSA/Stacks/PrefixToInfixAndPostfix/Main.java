import java.util.*;
  
public class Main{
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        valueOfExpression(str);

    }
    public static void valueOfExpression(String str)
    {
        // your code here
        System.out.println(solve(str));
		convert(str);
    }
	
	static int eval(int a, int b, char ch){

		if(ch == '+'){
			return a + b;
		}
		else if(ch == '-'){
			return a - b;
		}
		else if(ch == '*'){
			return a * b;
		}
		else{
			return a / b;
		}
	}
	
	static int solve(String str){

		Stack<Integer> opd = new Stack<>();

		for(int i = str.length() - 1; i >= 0; i--){

			char ch = str.charAt(i);

			if(Character.isDigit(ch)){
				opd.push(ch - '0');
			}
			else{
				int a = opd.pop();
				int b = opd.pop();
				opd.push(eval(a, b, ch));
			}
		}
		return opd.pop();
	}

	static void convert(String str){

		Stack<String> infix = new Stack<>();
		Stack<String> postfix = new Stack<>();

		for(int i = str.length() - 1; i >= 0; i--){

			char ch = str.charAt(i);

			if(Character.isDigit(ch)){
				infix.push(ch + "");
				postfix.push(ch + "");
			}
			else{
				String a = infix.pop();
				String b = infix.pop();
				String ans1 = "(" + a + ch + b + ")";
				infix.push(ans1);

				String c = postfix.pop();
				String d = postfix.pop();
				String ans2 = c + d + ch;
				postfix.push(ans2);
			}
		}
		System.out.println(infix.pop());
		System.out.println(postfix.pop());
	}
}

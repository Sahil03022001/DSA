import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s){
        //write code here
		Stack<Integer> open = new Stack<>();
		Stack<Integer> star = new Stack<>();
		for(int i = 0; i < n; i++){

			char ch = s.charAt(i);
			if(ch == '('){
				open.push(i);
			}else if(ch == '*'){
				star.push(i);
			}else{
				if(open.size() > 0){
					open.pop();
				}else if(star.size() > 0){
					star.pop();
				}else{
					return false;
				}
			}
		}
		if(open.size() == 0)return true;
		if(open.size() > 0 && star.size() == 0)return false;
		while(open.size() > 0 && star.size() > 0){
			int openidx = open.pop();
			int staridx = star.pop();
			if(openidx > staridx)return false;
		}
		return true;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n,s);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

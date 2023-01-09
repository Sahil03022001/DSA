import java.io.*;
import java.util.*;

public class Main {
	static String keypad[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    static void printKPC(String ques) {
        //Write your code here
		solve(ques, "", 0);
    }
	static void solve(String ques, String ans, int index){
		if(index == ques.length()){
			System.out.println(ans);
			return;
		}

		int digit = ques.charAt(index) - '0';
		for(int i = 0; i<keypad[digit].length(); i++){
			solve(ques, ans + keypad[digit].charAt(i), index+1);
		}
	}

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        printKPC(str);
    }
}
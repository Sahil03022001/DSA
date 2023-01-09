import java.util.*;

public class Main {
	static String str_to_map = " abcdefghijklmnopqrstuvwxyz";
    public static void printEncodings(String str) {
        // Write your code here
		solve(str, 0, "");
    }
	static void solve(String str, int index, String ans){
		if(index == str.length()){
			System.out.println(ans);
			return;
		}
		if(str.charAt(index) == '0')return;
		solve(str, index + 1, ans + str_to_map.charAt(str.charAt(index) - '0'));
		if(index+1 < str.length() && (str.charAt(index) == '1' || str.charAt(index) == '2' && str.charAt(index + 1) - '0' <= 6)){
			solve(str, index + 2, ans + str_to_map.charAt((str.charAt(index) - '0')*10 + (str.charAt(index + 1) - '0')));
		}
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}
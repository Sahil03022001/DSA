import java.io.*;
import java.util.*;
public class Main {
    public static long ways(int n, int i){
		if(i > n)return 0;
		if(i == n)return 1;
		return ways(n-i, i+1) + ways(n, i+1);
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(ways(n, 1));
    }
}

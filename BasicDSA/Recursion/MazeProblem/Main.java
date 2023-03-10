import java.io.*;
import java.util.*;

public class Main {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        //Write your code here
		if(sr == dr && sc == dc){
			System.out.println(psf);
			return;
		}
		if(sr > dr || sc > dc)return;

		
		for(int i=1; i<=dc; i++){
			printMazePaths(sr, sc + i, dr, dc, psf+ 'h' +i);
		}
		for(int i=1; i<=dr; i++){
			printMazePaths(sr + i, sc, dr, dc, psf+ 'v' +i);
		}
		for(int i=1; i<=dr; i++){
			printMazePaths(sr+i, sc+i, dr, dc, psf+ 'd' +i);
		}
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		printMazePaths(0, 0, n-1, m-1, "");
    }
}

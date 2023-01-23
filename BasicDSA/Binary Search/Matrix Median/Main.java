import java.util.ArrayList;

public class Solution
{

	static int countOfLessNumber(ArrayList<ArrayList<Integer>> matrix, int n, int m, int num){
		//this will count the numbers lesser than num
		int cnt = 0;
		int totalCnt = 0;
		for(int i = 0; i < n; i++){

			int lo = 0;
			int hi = m - 1;
			cnt = 0;
			while(lo <= hi){
				int mid = (lo + hi) / 2;

				if(matrix.get(i).get(mid) > num){
					hi = mid - 1;
				}
				else{
					cnt = mid + 1;
					lo = mid + 1;
				}
			}

			totalCnt += cnt;
		}

		return totalCnt;
	}

	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
		int n = matrix.size();
		int m = matrix.get(0).size();

		int lo = 1;
		int hi = 1000000000;
		int breakPoint = (n * m) / 2;

		while(lo <= hi){
			int mid = (lo + hi) / 2;

			if(countOfLessNumber(matrix, n, m, mid) <= breakPoint){
				lo = mid + 1;
			}
			else{
				hi = mid - 1;
			}
		}

		return lo;
	}
}
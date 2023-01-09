import java.util.*;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			Solution g = new Solution();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
        sc.close();
		
	}
}

class Solution
{
	Stack<Integer> st = new Stack<>();
    int minValue = Integer.MAX_VALUE;
	
	Solution()
	{
		
	}

	void push(int x){
        //Write Code here
		if(st.size() == 0){
			st.push(x);
			minValue = x;
		}else{
			if(x < minValue){
				int val = 2 * x - minValue;
				st.push(val);
				minValue = x;
			}else{
				st.push(x);
			}
		}
    }
	
	int pop(){
        //Write Code here
		if(st.size() == 0){
			return -1;
		}
		if(st.peek() > minValue){
			return st.pop();
		}else{
			int ans = minValue;
			int prevMin = 2 * minValue - st.pop();
			minValue = prevMin;
			return ans;
		}
	}

    int getMin(){
        //Write Code here
		if(st.size() == 0)return -1;
		return minValue;
	}	
}

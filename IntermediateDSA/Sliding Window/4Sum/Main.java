import java.util.*;
import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
       // Write your code here
	   List<List<Integer>> res = new ArrayList<>();
	   Arrays.sort(nums);
	   int n = nums.length;
	   for(int i = 0; i < n - 3; i++){
		   for(int j = i + 1; j < n - 2; j++){

				//find new Target and two sum of new Target
			   int newTarget = target - (nums[i] + nums[j]);
			   int l = j + 1;
			   int r = n - 1;
			   while(l < r){
				   int sum = nums[l] + nums[r];

				   if(sum == newTarget){
					   List<Integer> list = new ArrayList<>();
					   list.add(nums[i]);
					   list.add(nums[j]);
					   list.add(nums[l]);
					   list.add(nums[r]);
					   res.add(list);

					   l++;r--;

					   //for duplicates such that prev values not coming again
					   while(l  < r && nums[l] == nums[l - 1])l++;
					   while(l < r && nums[r] == nums[r + 1])r--;
				   }
				   else if(sum < newTarget){
					   l++;
					   while(l  < r && nums[l] == nums[l - 1])l++;
				   }
				   else{
					   r--;
					   while(l < r && nums[r] == nums[r + 1])r--;
				   }
			   }

			   //check duplicate for j and go to last index of current value
			   while(j + 1 < n && nums[j] == nums[j + 1])j++;

		   }

		    //check duplicate for i and go to last index of current value
			while(i + 1 < n && nums[i] == nums[i + 1])i++;
	   }

	   return res;
   }
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}
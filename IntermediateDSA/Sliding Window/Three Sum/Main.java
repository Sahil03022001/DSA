import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
    }
}

class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length < 3)return ans;
		
		Arrays.sort(nums);

		for(int i = 0; i < nums.length - 2; i++){
			if(i == 0 || nums[i] != nums[i - 1]){
				findTwoSum(nums, i, 0 - nums[i], ans);
			}
		}
		return ans;
        
    }
    
    static void findTwoSum(int[] nums, int i, int target, List<List<Integer>> ans){

		int first = nums[i];

		int left = i + 1;
        int right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            
            if(sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(nums[left]);
                list.add(nums[right]);
                ans.add(list);
                
                while(left < right && nums[left] == nums[left + 1])left++;
                while(left < right && nums[right] == nums[right - 1])right--;
                
                left++;
                right--;
            }
            
            else if(sum < target)left++;
            else right--;
        }
	}
}
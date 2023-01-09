public List<List<Integer>> subsetsWithDup(int[] nums) {
        
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    solve(ans, new ArrayList<>(), nums, 0);
    return ans;
}
private void solve(List<List<Integer>> ans, List<Integer> list, int[] nums, int index){
    
    ans.add(new ArrayList<>(list));
    for(int i = index; i < nums.length; i++){
        if(i != index && nums[i] == nums[i-1])continue;
        list.add(nums[i]);
        solve(ans, list, nums, i + 1);
        list.remove(list.size() - 1);
    }
    
}

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
    List<List<Integer>> ans = new ArrayList<>();
    solve(ans, new ArrayList<>(), candidates, target, 0);
    return ans;
}
private void solve(List<List<Integer>> ans, List<Integer> list, int[] arr, int target, int index){
    
    if(target < 0)return;
    
    if(index == arr.length){
        if(target == 0){
            ans.add(new ArrayList<>(list));
        }
        return;
    }
    
    list.add(arr[index]);
    solve(ans, list, arr, target - arr[index], index);
    list.remove(list.size() - 1);
    
    solve(ans, list, arr, target, index + 1);
}

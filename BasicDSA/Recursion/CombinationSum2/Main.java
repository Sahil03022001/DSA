public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    helper(ans, new ArrayList<>(), candidates, target, 0);
    return ans;
}

private void helper(List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int index){
    
    if(target == 0){
        ans.add(new ArrayList<>(list));
        return;
    }
    
    for(int i = index; i < candidates.length; i++){
        
        if(i != index && candidates[i] == candidates[i-1])continue;
        
        if(candidates[i] > target)break;
        
        list.add(candidates[i]);
        helper(ans, list, candidates, target - candidates[i], i + 1);
        list.remove(list.size() - 1);
    }
}

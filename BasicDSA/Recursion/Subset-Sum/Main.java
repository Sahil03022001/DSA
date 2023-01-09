ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
    // code here
    ArrayList<Integer> ans = new ArrayList<>();
    helper(ans, arr, N, 0, 0);
    return ans;
}
private void helper(ArrayList<Integer> ans, ArrayList<Integer> arr, int N, int index, int sum){
    
    if(index == N){
        ans.add(sum);
        return;
    }
    
    helper(ans, arr, N, index + 1, sum + arr.get(index));
    helper(ans, arr, N, index + 1, sum);
}
public List<List<String>> partition(String s) {
        
    List<List<String>> ans = new ArrayList<>();
    solve(ans, new ArrayList<>(), s, 0, "");
    return ans;
}

private void solve(List<List<String>> ans, List<String> list, String str, int i, String temp){
    
    if(i == str.length()){
        ans.add(new ArrayList<>(list));
        return;
    }
    
    for(int j = i; j < str.length(); j++){
        
        temp = str.substring(i, j + 1);
        if(!isPalindrome(temp))continue;
        list.add(temp);
        solve(ans, list, str, j + 1, temp);
        list.remove(list.size() - 1);
    }
}

private boolean isPalindrome(String str){
    
    int left = 0;
    int right = str.length() - 1;
    while(left < right){
        if(str.charAt(left) != str.charAt(right))return false;
        left++;
        right--;
    }
    return true;
}

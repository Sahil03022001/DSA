public String getPermutation(int n, int k) {
    ArrayList<Integer> arr = new ArrayList<>();
    int fact = 1;
    for(int i = 1; i < n; i++){
        fact = fact * i;
        arr.add(i);
    }
    arr.add(n);
    k--;
    StringBuilder ans = new StringBuilder();
    while(true){
        ans.append(arr.get(k / fact));		//adding required element to leftmost pos
        arr.remove(k / fact);			    //we dont need that anymore so removing

        if(arr.size() == 0)break;		

        k = k % fact;				        //updating value of k
        fact = fact / arr.size();			//updating value of fact
    }
    return ans.toString();
}

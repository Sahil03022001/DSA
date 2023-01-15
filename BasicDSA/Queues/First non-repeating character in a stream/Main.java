class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        if(A.length() == 1)return A;
        int[] f = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        
        for(char ch : A.toCharArray()){
            
            f[ch - 97]++;
            while(!q.isEmpty() && f[q.peek() - 97] > 1){
                q.poll();
            }
            if(f[ch - 97] == 1){
                q.add(ch);
            }
            if(q.isEmpty()){
                ans.append('#');
            }else{
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
}
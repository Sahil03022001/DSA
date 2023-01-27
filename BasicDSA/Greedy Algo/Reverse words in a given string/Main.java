class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        String arr[] = S.split("[.]");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i > -1; i--){
            sb.append(arr[i]);
            if(i > 0)
            sb.append(".");
        }
        
        return sb.toString();
    }
}
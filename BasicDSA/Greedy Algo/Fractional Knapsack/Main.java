/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> a.value * b.weight - b.value * a.weight);
        
        double maxValue = 0;
        for(int i = n - 1; i >= 0; i--){
            
            if(arr[i].weight > W){
                maxValue += W * (double)arr[i].value / arr[i].weight;
                break;
            }
            else{
                maxValue += arr[i].value;
                W -= arr[i].weight;
            }
        }
        
        return maxValue;
    }
}
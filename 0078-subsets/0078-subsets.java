class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List <Integer> subset = new ArrayList<>();
    int[] numbers;
    public List<List<Integer>> subsets(int[] nums) 
    {   
       dfs(0, nums);
       return this.result;
    }
    
    private void dfs(int i, int[] numbers)
       {
           if (i>=numbers.length)
           {
               this.result.add(new ArrayList<>(subset));
               //System.out.println("Main: " + result);
               return;
           }
            subset.add(numbers[i]);
            dfs(i+1, numbers);

            //System.out.print(i);
            subset.remove(Integer.valueOf(numbers[i]));
            dfs(i+1, numbers);
       }
}
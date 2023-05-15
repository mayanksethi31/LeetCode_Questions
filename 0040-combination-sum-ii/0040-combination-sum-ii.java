class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {   
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        depth_sum(0, candidates, subset, result, target);
        return result;
    }

    private void depth_sum(int pointer, int[] nums, List<Integer> subset, List<List<Integer>> result, int target)
    {
        if (target==0)
        {
            result.add(new ArrayList<>(subset));
        }
        if (target<0)
        {
            return;
        }

        int prev =-1; 
        for(int i = pointer; i<nums.length; i++)
        {
            if (prev==nums[i]) continue; 
            subset.add(nums[i]);
            depth_sum(i+1, nums, subset, result, target-nums[i]);
            subset.remove(subset.size()-1);
            prev = nums[i];
        
        }
        
    }
}
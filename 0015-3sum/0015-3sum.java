import java.util.*; 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {

    List<List<Integer>> final_res = new ArrayList<>();
    Arrays.sort(nums);

    int l=0;
    int r= nums.length-1;
    int a =0;
    int sum=0;

    for(int i=0; i<nums.length; i++)
    {   a = nums[i];
        if ((i>0) && (nums[i-1] == a)) continue;
        l = i+1;
        r = nums.length-1;
        while(l<r)
        {
            sum = nums[i] + nums[l] + nums[r];
            if (sum>0) r--;
            else if (sum<0) l++;
            else 
            {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[i]);
                ans.add(nums[l]);
                ans.add(nums[r]);
                final_res.add(ans);
                l++;
                while (nums[l] == nums[l-1] && l<r) {l++;}
            }
        }
    }
    return final_res;
    }
}
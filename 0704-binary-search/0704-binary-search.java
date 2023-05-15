import java.util.*;
class Solution {
    public int search(int[] nums, int target)
    {   
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        
        while (start<=end)
        {
        mid = start + ((end-start)/2);

        // System.out.println(mid + " " + start + " " + end);
        if (target == nums[mid])
        {
            return mid;
        }
        else if (target<nums[mid])
        {   
            end = (mid-1);
        } 
        else if (target>nums[mid])
        {
            start = (mid+1);
        }
        }
        return -1; 
    }
}
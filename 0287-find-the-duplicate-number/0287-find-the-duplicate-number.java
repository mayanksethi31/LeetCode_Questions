class Solution {
    public int findDuplicate(int[] nums) 
    {
        int slow = nums[0];
        int fast = nums[0];

        while (true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            //System.out.println(slow + " : " + fast);
            if(slow == fast) break;
        }
        slow = nums[0];
        
        while (fast!=slow)
        {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) break;
        }
        return slow;
    }
}
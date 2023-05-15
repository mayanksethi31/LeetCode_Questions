class Solution {
    
    public int findMin(int[] nums) {
    
    int left = 0;
    int len = nums.length;
    int right = len-1;
    
    int mid=0;

    while (left<=right)
    {
         mid=(left+right)/2;
         if (nums[mid]>nums[right])
         { left=mid+1;}
         else if (nums[mid]<nums[right])
         { right=mid; }
         else
         {break;}
    }

    return nums[mid]; 

    }
}
class Solution {
    public int trap(int[] height) {
        if (height == null) return 0;
        int max_l=height[0];
        int max_r=height[height.length-1];
        int l = 0, r = height.length-1;
        int sum=0;
        while (l<r)
        {
            if (max_l<max_r) 
            {
            l++; 
            sum+=(Math.max(max_l,height[l]) - height[l]);
            max_l= Math.max(max_l, height[l]);
            }
            else  
            {
            r--;
            sum+=(Math.max(max_r,height[r]) - height[r]);
            max_r= Math.max(max_r, height[r]);
            }
        }
        return sum;
    }
}
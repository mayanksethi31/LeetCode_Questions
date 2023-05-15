class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int l = 0 ;
        int r = height.length-1;
        int area = 0;

        while(l<r)
        {
            area = Math.min(height[l], height[r]) * (r-l);
            //System.out.println(area + " : " + l + " : " + r);
            if (area>max_area) max_area=area;
            if (height[l]<height[r]) l++;
            else r--;
        }
        return max_area;
    }
}
import java.util.*;
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total_size = nums1.length + nums2.length;
    int mid = 0;
    int aleft, aright, bleft, bright;
    int[] a = nums1;
    int[] b = nums2;
    if (nums1.length < nums2.length) {
      int[] c = b;
      b = a;
      a = c;
    }

    int left = 0;
    int right = b.length - 1;
    if (b.length==0)
    {
      if (total_size%2==0)
      {
        return (a[(total_size/2)-1] + a[(total_size/2)])/2.0;
      }
      return a[total_size/2];
    }
    while (left<=right+2) {
      mid = (left + right) / 2;
      int check = (total_size / 2) - (mid + 1) - 1;
      aleft = (check >= 0) ? a[check] : Integer.MIN_VALUE;
      aright = (check + 1 < a.length) ? a[check + 1] : Integer.MAX_VALUE;
      bleft = (mid >= 0) ? b[mid] : Integer.MIN_VALUE;
      bright = (mid + 1 < b.length) ? b[mid + 1] : Integer.MAX_VALUE;
      if (aleft <= bright && bleft<=aright) 
      {
       
        if (total_size % 2 == 0) {
          return (Math.min(aright, bright) + Math.max(aleft, bleft)) / 2.0;
        } 
        return Math.min(aright, bright);
      } 
      else if (aright < bleft) 
      {
        if (mid==0)
        {
          right = mid-2;
        }
        else
        {
        right = mid - 1;
        }
      } 
      else 
      {
        if(mid==b.length-1)
        {
          left = mid+2;
        }
        else
        {
        left = mid + 1;
        }
      }
     
    }
    return 1.0;
  }
}

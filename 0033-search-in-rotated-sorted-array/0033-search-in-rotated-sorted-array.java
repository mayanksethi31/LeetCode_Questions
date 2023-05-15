import java.util.*;
class Solution {
    public int search(int[] nums, int target) 
    {

     int left = 0;
     int len = nums.length;
     int right = len-1;
     
     int mid=0;

     while (left<=right)
     {
          mid=(left+right)/2;
        
         if (nums[mid]>nums[right])
         {
             left=mid+1;
         }
         else if (nums[mid]<nums[right])
         {
             right=mid;
         }
         else
         {
             break;
         }
         //System.out.println("Mid: "+mid+ " "+ " left: " + left + " right: " + right);

     }
     
     int pivot=mid;

     //System.out.println("Pivot: "+pivot);

     left = pivot; 
     right = pivot+len-1;
     while (left<=right)
     {
         mid = (left+right)/2;
         if (target<nums[mid%len])
         {
             right=mid-1;
         }
         else if (target>nums[mid%len])
         {
             left=mid+1;
         }
         else
         {
             return mid%len;
         }
     }
     
     return -1;

        
    }
}
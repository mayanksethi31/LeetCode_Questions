import java.io.*;
class Solution 
{
    public int maxProfit(int[] prices) 
    {   
        int left=0;
        int right=1;
        int maxi=0;
        if ((prices.length)>1)
            {
            left=0;
            right=1;
            maxi = prices[right]-prices[left];
            while (right < prices.length)
                {if (prices[right]<prices[left])
                    {left=right;}
                if (maxi<prices[right]-prices[left])
                    {maxi=prices[right]-prices[left];}
                right+=1;
                }}
        else
        {return 0;}

        if (maxi>0)
        
        {return maxi;}
        else
        {
            return 0;
        } 
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        int max_length = 0;
        int length=0;
        int j=0;
        Set<Integer> check = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        //System.out.println(check);
        for(int i:nums)
        {
            if (!check.contains((i-1)))
            {
                length = 1;
                j = i+1;
                while (check.contains(j))
                {
                    j+=1;
                    length+=1;
                }
                if (length>max_length) max_length=length;
            }
            if (check.contains((i-1))) continue;
        }
        return max_length;

    }
}
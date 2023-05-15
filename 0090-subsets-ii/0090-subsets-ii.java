class Solution {
    List<List<Integer>> result= new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] freq =new int[21];
        for(int i=0; i<nums.length;i++){
            freq[nums[i]+10]+=1;
        }
        
        
        helper(new ArrayList<>(),0, freq);
        result.add(new ArrayList<>());
        return result;


    }

    private void helper(List<Integer> running, int index, int[] freq){
        if(index>=freq.length){
            return;
        }
        helper(running, index+1, freq);
        for(int i=0; i<freq[index];i++){
            List<Integer> withCurr= new ArrayList<>(running);
            for(int j=0;j<=i;j++){
                withCurr.add(index-10);
            }
            result.add(withCurr);
            helper(withCurr,index+1,freq);
        }

    }
}
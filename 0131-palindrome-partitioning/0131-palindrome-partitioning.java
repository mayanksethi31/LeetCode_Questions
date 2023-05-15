class Solution 
{   
    List<String> subset_1;
    List<List<String>> result;
        
        public List<List<String>> partition(String s) 
        {   
            result = new ArrayList<>();
            subset_1 = new ArrayList<>();
            backtrack(0, s);
            return result;
        }

    private void backtrack(int pointer, String s) {
    if (pointer>=s.length())
    {
        result.add(new ArrayList(subset_1));
        return;
    }
    for(int i = pointer; i< s.length(); i++)
    {
            if (palindrome(s, pointer, i))
            {
                subset_1.add(new String(s.substring(pointer, i+1)));
                backtrack(i+1, s);
                subset_1.remove(subset_1.size()-1);
            }
        }
    }
    private boolean palindrome(String check, int i , int j) 
    { 
        //System.out.println("Mera: "); 
        if (i>=j) return true;
        if (check.charAt(i)!=check.charAt(j)) return false;
        return palindrome(check, i+1, j-1);
    }
}

class Solution {
    HashMap<Character, String[]> correspond;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        correspond = new HashMap<>(); 
        correspond.put('2', new String[]{"a", "b", "c"});
        correspond.put('3', new String[]{"d", "e", "f"});
        correspond.put('4', new String[]{"g", "h", "i"});
        correspond.put('5', new String[]{"j", "k", "l"});
        correspond.put('6', new String[]{"m", "n", "o"});
        correspond.put('7', new String[]{"p", "q", "r", "s"});
        correspond.put('8', new String[]{"t", "u", "v"});
        correspond.put('9', new String[]{"w", "x", "y", "z"});
        result = new ArrayList<>();
        String subset = "";
        if (digits.length()>0) backtrack(0, digits, subset);
        return result;

    }
    private void backtrack(int j, String digits, String subset)
    {
    if (subset.length() == digits.length())
    {   
        result.add(new String(subset));
        return;
    }
    for(int i = 0; i < this.correspond.get(digits.charAt(j)).length; i++)
        {  
            subset += correspond.get(digits.charAt(j))[i];
            backtrack(j+1, digits, subset);
            subset = subset.substring(0, subset.length() - 1); 
        }
    }    
}
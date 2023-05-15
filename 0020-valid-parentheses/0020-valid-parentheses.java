class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');
        for (int i=0; i<s.length(); i++)
        {
            if (closeToOpen.containsKey(s.charAt(i)))
            {
                if ((!stack.empty()) && stack.peek() == closeToOpen.get(s.charAt(i)))
                {
                    stack.pop();
                }
                else {return false;}
            }
            else
            stack.push(s.charAt(i));
            // #System.out.println(stack);
        }

        if (stack.empty()) return true;
        return false;
        
 
    }
}
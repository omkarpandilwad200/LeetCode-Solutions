import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 
            // Handle closing brackets
            else {
                // If stack is empty, there is no matching opening bracket
                if (st.isEmpty()) {
                    return false;
                }
                
                char top = st.peek();
                // Check if the top of the stack matches the current closing bracket
                if ((top == '(' && ch == ')') || 
                    (top == '{' && ch == '}') || 
                    (top == '[' && ch == ']')) {
                    st.pop();
                } else {
                    // Mismatched bracket type (e.g., top is '{' but ch is ')')
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were properly closed
        return st.isEmpty();
    }
}

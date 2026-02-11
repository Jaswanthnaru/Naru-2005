class Node{
    char ch;
    int idx;
    Node(char c, int i){
        ch = c;
        idx = i;
    }
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Node> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(ch != '(' && ch != ')') continue;
            if(!stack.isEmpty() && ch == ')' && stack.peek().ch == '(') stack.pop();
            else stack.push(new Node(ch,i));
        }

        if(stack.isEmpty()) return s;
        StringBuilder str = new StringBuilder(s);
        while(!stack.isEmpty()) str.deleteCharAt(stack.pop().idx);
        return new String(str);
    }
}
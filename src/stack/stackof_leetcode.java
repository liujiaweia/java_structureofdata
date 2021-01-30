package stack;

import java.util.Stack;

public class stackof_leetcode {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        for(int i=0;i<s.length();i++){
            char k = s.charAt(i);
            if(k=='('||k=='['||k=='{'){
                res.push(k);
            }else{
                if(res.isEmpty()){
                    return false;
                }
                char c = res.peek();
                if(k==')'&&c=='('){
                    res.pop();
                }else if(k==']'&&c=='['){
                    res.pop();
                }else if(k=='}'&&c=='{'){
                    res.pop();
                }else
                    return false;
            }
        }
        if(res.isEmpty()){
            return true;
        }else
            return false;
    }
}

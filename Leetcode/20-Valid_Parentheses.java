import java.io.*;
import java.util.*;
class Solution {
    public  boolean isValid(String s) {
        char[] br = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < br.length; i++) {
            if (br[i] == '('
                    || br[i] == '{'
                    || br[i] == '[') {
                st.push(br[i]);
            } else if (br[i] == ')'
                    || br[i] == '}'
                    || br[i] == ']') {
                if (st.empty()) {
                    return false;
                } else {
                    char top = st.pop();
                    if ((top=='[' && br[i]!=']')
                    || (top=='(' && br[i]!=')')
                    || (top=='{' && br[i]!='}')) {
                        return false;
                    }
                }

            } else {
                return false;
            }
        }

        if(st.empty()){
            return true;
        }  return false;
    }
    
    
}
package liu.Leecode;

import java.util.*;

public class leecode71 {
    public String simplifyPath(String path) {
        List<String> strings = Arrays.asList(path.split("/"));
        Stack<String> stringStack = new Stack<>();
        for(String s : strings) {
            if(s.equals(".") || s.equals("")) continue;
            if(s.equals("..")) {
                if(stringStack.empty()) continue;
                stringStack.pop();
            }
            else {
                stringStack.push(s);
            }
        }
        String re = "";
        while (!stringStack.empty()){
            if(re.length() != 0) re = "/" + re;
            re = stringStack.pop()  + re;
        }
        return "/" + re;
    }

}
